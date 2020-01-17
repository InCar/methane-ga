package com.incarcloud.impl;

import com.incarcloud.config.kafka.ProducerUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Component
public class GatherMQ_Kafka extends AbstractConsumer<String,byte[]> implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    GatherChannelMQ_kafka gatherChannelMQ_kafka;

    public GatherMQ_Kafka(@Qualifier("consumerProperties") Properties properties, @Value("${spring.kafka.consumer.max-blocking-num:100000}") Integer maxBlockingNum, @Value("#{'${spring.kafka.consumer.topic}'.split(',')}") String[] topics) {
        super(properties,(ThreadPoolExecutor) Executors.newFixedThreadPool(1),Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()),maxBlockingNum,topics);
    }

    @Override
    public void onMessage(ConsumerRecord<String, byte[]> consumerRecord) {
        System.out.println(new String(consumerRecord.value()));
        gatherChannelMQ_kafka.store(consumerRecord.value());
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        start();
        testSend();
    }

    public void testSend(){
        Producer producer=ProducerUtil.getProducer();
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            Date cur=new Date();
            for (String topic : topics) {
                producer.send(new ProducerRecord(topic,cur.toString().getBytes()));
            }
        },1,1, TimeUnit.SECONDS);
    }
}
