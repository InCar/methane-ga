package com.incarcloud.resource_1.std.impl;

import com.google.protobuf.ByteString;
import com.incarcloud.resource_1.std.Resource;
import com.incarcloud.resource_1.std.ResourceServiceGrpc;
import com.incarcloud.resource_1.structure.data.ResourceFragment;
import com.incarcloud.resource_1.structure.data.ResourceInfo;
import com.incarcloud.resource_1.structure.server.ResourceStoreHandler;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResourceService extends ResourceServiceGrpc.ResourceServiceImplBase {

    @Autowired
    ResourceStoreHandler resourceStoreHandler;

    Logger logger= LoggerFactory.getLogger(ResourceService.class);
    @Override
    public void pullInfo(Resource.ResourceInfoPullRequest request, StreamObserver<Resource.ResourceInfoPullResponse> responseObserver) {
        logger.info("==========receive request pullInfo[{}]",request.getId());
        ResourceInfo resourceInfo= resourceStoreHandler.get(request.getId());
        Resource.ResourceInfoPullResponse response;
        if(resourceInfo==null){
            response= Resource.ResourceInfoPullResponse.newBuilder().setCode(2).build();
        }else{
            response=Resource.ResourceInfoPullResponse.newBuilder().setCode(1).setFragment(resourceInfo.getFragment()).setVersion(resourceInfo.getVersion()).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void pullData(Resource.ResourceDataPullRequest request, StreamObserver<Resource.ResourceDataPullResponse> responseObserver) {
        ResourceFragment fragment= resourceStoreHandler.getFragment(request.getId(),request.getVersion(),request.getStart(),request.getEnd());
        Resource.ResourceDataPullResponse response;
        if(fragment==null){
            response= Resource.ResourceDataPullResponse.newBuilder().setCode(2).build();
        }else{
            response=Resource.ResourceDataPullResponse.newBuilder().setCode(1).setData(ByteString.copyFrom(fragment.getContent())).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }

    @Override
    public void pushInfo(Resource.ResourceInfoPushRequest request, StreamObserver<Resource.ResourceInfoPushResponse> responseObserver) {
        String id=resourceStoreHandler.create();
        Resource.ResourceInfoPushResponse response;
        if(id==null){
            response=Resource.ResourceInfoPushResponse.newBuilder().setCode(2).build();
        }else{
            response=Resource.ResourceInfoPushResponse.newBuilder().setCode(1).setId(id).build();
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void pushData(Resource.ResourceDataPushRequest request, StreamObserver<Resource.ResourceDataPushResponse> responseObserver) {
        int res=resourceStoreHandler.put(request.getId(),request.getStart(),request.getData().toByteArray());
        Resource.ResourceDataPushResponse response=Resource.ResourceDataPushResponse.newBuilder().setCode(res).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
