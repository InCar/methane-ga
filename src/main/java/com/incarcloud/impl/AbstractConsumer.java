package com.incarcloud.impl;

import com.incarcloud.core.GatherMQ;
import org.apache.kafka.clients.consumer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractConsumer<K,V> extends GatherMQ {

    protected Logger logger= LoggerFactory.getLogger(this.getClass());

    protected ThreadLocal<Consumer<K,V>> consumers=new ThreadLocal<>();

    protected String[] topics;

    protected Properties consumerProperties;

    protected ThreadPoolExecutor consumerPool;

    protected ExecutorService workPool;

    protected AtomicInteger blockingNum;

    protected Integer maxBlockingNum;

    protected volatile boolean stop=false;

    ReentrantLock lock=new ReentrantLock();

    public AtomicInteger getBlockingNum() {
        return blockingNum;
    }

    /**
     *
     * @param properties 消费者参数
     * @param consumerPool 消费线程池(必须用Executors.newFixedThreadPool)
     * @param workPool 工作线程池
     * @param maxBlockingNum 最大阻塞数量
     * @param topics 消费topic
     */
    public AbstractConsumer(Properties properties,ThreadPoolExecutor consumerPool,ExecutorService workPool, Integer maxBlockingNum, String ... topics) {
        this.consumerProperties=properties;
        this.consumerPool=consumerPool;
        this.maxBlockingNum=maxBlockingNum;
        this.blockingNum =new AtomicInteger(0);
        this.workPool=workPool;
        this.topics=topics;

    }

    /**
     * 获取消费者
     * @return
     */
    private Consumer<K,V> getConsumer(){
        Consumer<K,V> consumer=consumers.get();
        if(consumer==null) {
            consumer = new KafkaConsumer<>(consumerProperties);
            consumer.subscribe(Arrays.asList(topics));
            consumers.set(consumer);
        }
        return consumer;
    }

    public AbstractConsumer(Properties properties, String topic) {
        this(properties,(ThreadPoolExecutor)Executors.newFixedThreadPool(1),Executors.newFixedThreadPool(10),10000,topic);
    }

    /**
     * 消费
     * @return
     */
    public ConsumerRecords<K,V> consume(){
        if(blockingNum.get()>=maxBlockingNum){
            //休眠1000ms
            try {
                Thread.sleep(1000L);
                return null;
            } catch (InterruptedException e) {
                logger.error("interrupt",e);
            }
        }
        ConsumerRecords<K,V> res;
        try{
            res=getConsumer().poll(100L);
        }catch (Exception ex){
            res=null;
            logger.error("poll data error",ex);
        }
        if(res!=null) {
            int count=res.count();
            if(count==0){
                return null;
            }
            blockingNum.addAndGet(count);

        }
        return res;
    }

    public abstract void onMessage(ConsumerRecord<K,V> consumerRecord);

    @Override
    public void start() {
        lock.lock();
        try {
            super.start();
            stop = false;
            for(int i=1;i<=consumerPool.getMaximumPoolSize();i++){
                consumerPool.execute(() -> {
                    while (!stop) {
                        try {
                            ConsumerRecords<K, V>[] data = new ConsumerRecords[1];
                            data[0] = consume();
                            if (data[0] != null) {
                                workPool.execute(() -> {
                                    try {
                                        Iterator<ConsumerRecord<K, V>> it = data[0].iterator();
                                        while (it.hasNext()) {
                                            onMessage(it.next());
                                        }
                                    } catch (Exception e) {
                                        logger.error(e.getMessage(), e);
                                    }
                                });
                            }
                        } catch (Exception e) {
                            logger.error("Kafka Consumer[" + Arrays.stream(topics).reduce((e1, e2) -> e1 + "," + e2) + "] Cycle Error", e);
                            return;
                        }
                    }
                    logger.info("exit consume...");
                });
            }
        }finally {
            lock.unlock();
        }
    }

    @Override
    public synchronized void stop() {
        lock.lock();
        try {
            super.stop();
            stop = true;
        }finally {
            lock.unlock();
        }
    }
}
