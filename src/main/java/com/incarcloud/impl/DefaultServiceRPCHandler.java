package com.incarcloud.impl;

import com.incarcloud.core.ServiceRPCHandler;
import com.incarcloud.std.HelloServiceV1Grpc;
import com.incarcloud.std.HelloV;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultServiceRPCHandler extends ServiceRPCHandler {
    Logger logger= LoggerFactory.getLogger(DefaultServiceRPCHandler.class);
    ManagedChannel _channel = ManagedChannelBuilder.forAddress("10.0.14.73", 9999)
            .usePlaintext()
            .build();
    HelloServiceV1Grpc.HelloServiceV1BlockingStub _blockingStub = HelloServiceV1Grpc.newBlockingStub(_channel);
    @Override
    public void doService(HelloV.HelloRequestV1 request) {
        HelloV.HelloRequestV1 helloRequestV1 = HelloV.HelloRequestV1.newBuilder().setVin(request.getVin()).build();
        try {
            HelloV.HelloResponseV1 helloResponseV1 = _blockingStub.hello(helloRequestV1);
            logger.info("send[{}],response[{}]",helloRequestV1.getVin(),helloResponseV1.getRes());
        }catch (Exception ex){
            logger.error("call error",ex);
        }

    }
}
