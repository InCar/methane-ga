package com.incarcloud.impl;

import com.incarcloud.core.GatherChannelMQ;
import com.incarcloud.core.ServiceRPCHandler;
import com.incarcloud.std.HelloV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GatherChannelMQ_kafka extends GatherChannelMQ {

    Logger logger= LoggerFactory.getLogger(GatherChannelMQ_kafka.class);

    @Autowired
    ServiceRPCHandler serviceRPCHandler;

    @Override
    public void doChannel(HelloV.HelloRequestV1 helloRequestV1) {
        serviceRPCHandler.doService(helloRequestV1);
    }
}
