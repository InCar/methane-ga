package com.incarcloud.impl;

import com.google.protobuf.InvalidProtocolBufferException;
import com.incarcloud.config.kafka.ProducerUtil;
import com.incarcloud.std.HelloV;
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
        try {
            HelloV.HelloRequestV1 requestV1= HelloV.HelloRequestV1.parseFrom(consumerRecord.value());
            logger.info("receive[{}]",requestV1.getVin());
            gatherChannelMQ_kafka.doChannel(requestV1);
        } catch (InvalidProtocolBufferException e) {
            logger.error("parse error",e);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        start();
        testSend();
    }

    public void testSend(){
        Producer producer=ProducerUtil.getProducer();
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            Date time=new Date();
            HelloV.HelloRequestV1 requestV1= HelloV.HelloRequestV1.newBuilder().setVin(time.toString()).build();
            for (String topic : topics) {
                producer.send(new ProducerRecord(topic,requestV1.toByteArray()));
            }
        },1,3, TimeUnit.SECONDS);
    }
}
