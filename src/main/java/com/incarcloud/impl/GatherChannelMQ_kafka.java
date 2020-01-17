package com.incarcloud.impl;

import com.google.protobuf.InvalidProtocolBufferException;
import com.incarcloud.core.GatherChannelMQ;
import com.incarcloud.std.HelloV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;

@Component
public class GatherChannelMQ_kafka extends GatherChannelMQ {

    Logger logger= LoggerFactory.getLogger(GatherChannelMQ_kafka.class);

    static LinkedBlockingQueue<byte[]> DATA_QUEUE =new LinkedBlockingQueue<>();

    @Override
    public void doChannel() {
        while(true){
            byte[] data= DATA_QUEUE.poll();
            try {
                HelloV.HelloRequestV1 requestV1= HelloV.HelloRequestV1.parseFrom(data);
                logger.info(requestV1.getVin());
            } catch (InvalidProtocolBufferException e) {
                logger.error("parse error",e);
            }
        }
    }

    public void store(byte[] data){
        DATA_QUEUE.add(data);
    }
}
