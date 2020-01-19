package com.incarcloud.impl;

import com.incarcloud.core.ServiceMQHandler;
import com.incarcloud.std.HelloServiceV1Grpc;
import com.incarcloud.std.HelloV;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

@Component
public class DefaultServiceHandler extends ServiceMQHandler {
    ManagedChannel _channel = ManagedChannelBuilder.forAddress("127.0.0.1", 8888)
            .usePlaintext()
            .build();
    HelloServiceV1Grpc.HelloServiceV1BlockingStub _blockingStub = HelloServiceV1Grpc.newBlockingStub(_channel);
    @Override
    public void doService(HelloV.HelloRequestV1 request) {
        HelloV.HelloRequestV1 helloRequestV1 = HelloV.HelloRequestV1.newBuilder().setVin(request.getVin()).build();
        HelloV.HelloResponseV1 hello = _blockingStub.hello(helloRequestV1);
    }
}
