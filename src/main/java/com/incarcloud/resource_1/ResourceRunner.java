package com.incarcloud.resource_1;

import com.incarcloud.resource_1.std.Resource;
import com.incarcloud.resource_1.std.ResourceServiceGrpc;
import com.incarcloud.resource_1.std.impl.ResourceService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class ResourceRunner implements CommandLineRunner {

    Logger logger= LoggerFactory.getLogger(ResourceRunner.class);

    @Autowired
    ResourceService resourceService;

    @Override
    public void run(String... args) throws Exception {
        ServerBuilder.forPort(12345).addService(resourceService).build().start();
        mockClient();
    }

    public void mockClient(){
        ManagedChannel _channel = ManagedChannelBuilder.forAddress("127.0.0.1", 12345)
                .usePlaintext()
                .build();
        ResourceServiceGrpc.ResourceServiceBlockingStub _blockingStub = ResourceServiceGrpc.newBlockingStub(_channel);
        Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(()->{
            Date date=new Date();
            Resource.ResourceInfoPullRequest request= Resource.ResourceInfoPullRequest.newBuilder().setId(date.toString()).build();
            Resource.ResourceInfoPullResponse response= _blockingStub.pullInfo(request);
            logger.info("==========receive response pullInfo[{}]",response.getCode());
        },1,3, TimeUnit.SECONDS);

    }
}
