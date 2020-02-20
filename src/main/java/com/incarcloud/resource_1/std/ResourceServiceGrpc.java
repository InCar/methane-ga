package com.incarcloud.resource_1.std;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.0-pre2)",
    comments = "Source: Resource.proto")
public class ResourceServiceGrpc {

  private ResourceServiceGrpc() {}

  public static final String SERVICE_NAME = "com.incarcloud.resource_1.std.ResourceService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Resource.ResourceInfoPullRequest,
      Resource.ResourceInfoPullResponse> METHOD_PULL_INFO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.incarcloud.resource_1.std.ResourceService", "pullInfo"),
          io.grpc.protobuf.ProtoUtils.marshaller(Resource.ResourceInfoPullRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(Resource.ResourceInfoPullResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Resource.ResourceDataPullRequest,
      Resource.ResourceDataPullResponse> METHOD_PULL_DATA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.incarcloud.resource_1.std.ResourceService", "pullData"),
          io.grpc.protobuf.ProtoUtils.marshaller(Resource.ResourceDataPullRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(Resource.ResourceDataPullResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Resource.ResourceInfoPushRequest,
      Resource.ResourceInfoPushResponse> METHOD_PUSH_INFO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.incarcloud.resource_1.std.ResourceService", "pushInfo"),
          io.grpc.protobuf.ProtoUtils.marshaller(Resource.ResourceInfoPushRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(Resource.ResourceInfoPushResponse.getDefaultInstance()));
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<Resource.ResourceDataPushRequest,
      Resource.ResourceDataPushResponse> METHOD_PUSH_DATA =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.incarcloud.resource_1.std.ResourceService", "pushData"),
          io.grpc.protobuf.ProtoUtils.marshaller(Resource.ResourceDataPushRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(Resource.ResourceDataPushResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ResourceServiceStub newStub(io.grpc.Channel channel) {
    return new ResourceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ResourceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ResourceServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static ResourceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ResourceServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ResourceServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *拉取资源信息
     * </pre>
     */
    public void pullInfo(Resource.ResourceInfoPullRequest request,
                         io.grpc.stub.StreamObserver<Resource.ResourceInfoPullResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PULL_INFO, responseObserver);
    }

    /**
     * <pre>
     *拉取资源内容
     * </pre>
     */
    public void pullData(Resource.ResourceDataPullRequest request,
                         io.grpc.stub.StreamObserver<Resource.ResourceDataPullResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PULL_DATA, responseObserver);
    }

    /**
     * <pre>
     *推送资源信息
     * </pre>
     */
    public void pushInfo(Resource.ResourceInfoPushRequest request,
                         io.grpc.stub.StreamObserver<Resource.ResourceInfoPushResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PUSH_INFO, responseObserver);
    }

    /**
     * <pre>
     *推送资源内容
     * </pre>
     */
    public void pushData(Resource.ResourceDataPushRequest request,
                         io.grpc.stub.StreamObserver<Resource.ResourceDataPushResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_PUSH_DATA, responseObserver);
    }

    @Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_PULL_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                Resource.ResourceInfoPullRequest,
                Resource.ResourceInfoPullResponse>(
                  this, METHODID_PULL_INFO)))
          .addMethod(
            METHOD_PULL_DATA,
            asyncUnaryCall(
              new MethodHandlers<
                Resource.ResourceDataPullRequest,
                Resource.ResourceDataPullResponse>(
                  this, METHODID_PULL_DATA)))
          .addMethod(
            METHOD_PUSH_INFO,
            asyncUnaryCall(
              new MethodHandlers<
                Resource.ResourceInfoPushRequest,
                Resource.ResourceInfoPushResponse>(
                  this, METHODID_PUSH_INFO)))
          .addMethod(
            METHOD_PUSH_DATA,
            asyncUnaryCall(
              new MethodHandlers<
                Resource.ResourceDataPushRequest,
                Resource.ResourceDataPushResponse>(
                  this, METHODID_PUSH_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class ResourceServiceStub extends io.grpc.stub.AbstractStub<ResourceServiceStub> {
    private ResourceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResourceServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ResourceServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ResourceServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *拉取资源信息
     * </pre>
     */
    public void pullInfo(Resource.ResourceInfoPullRequest request,
                         io.grpc.stub.StreamObserver<Resource.ResourceInfoPullResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PULL_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *拉取资源内容
     * </pre>
     */
    public void pullData(Resource.ResourceDataPullRequest request,
                         io.grpc.stub.StreamObserver<Resource.ResourceDataPullResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PULL_DATA, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *推送资源信息
     * </pre>
     */
    public void pushInfo(Resource.ResourceInfoPushRequest request,
                         io.grpc.stub.StreamObserver<Resource.ResourceInfoPushResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUSH_INFO, getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *推送资源内容
     * </pre>
     */
    public void pushData(Resource.ResourceDataPushRequest request,
                         io.grpc.stub.StreamObserver<Resource.ResourceDataPushResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_PUSH_DATA, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ResourceServiceBlockingStub extends io.grpc.stub.AbstractStub<ResourceServiceBlockingStub> {
    private ResourceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResourceServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ResourceServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ResourceServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *拉取资源信息
     * </pre>
     */
    public Resource.ResourceInfoPullResponse pullInfo(Resource.ResourceInfoPullRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PULL_INFO, getCallOptions(), request);
    }

    /**
     * <pre>
     *拉取资源内容
     * </pre>
     */
    public Resource.ResourceDataPullResponse pullData(Resource.ResourceDataPullRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PULL_DATA, getCallOptions(), request);
    }

    /**
     * <pre>
     *推送资源信息
     * </pre>
     */
    public Resource.ResourceInfoPushResponse pushInfo(Resource.ResourceInfoPushRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PUSH_INFO, getCallOptions(), request);
    }

    /**
     * <pre>
     *推送资源内容
     * </pre>
     */
    public Resource.ResourceDataPushResponse pushData(Resource.ResourceDataPushRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_PUSH_DATA, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ResourceServiceFutureStub extends io.grpc.stub.AbstractStub<ResourceServiceFutureStub> {
    private ResourceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ResourceServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ResourceServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ResourceServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *拉取资源信息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Resource.ResourceInfoPullResponse> pullInfo(
        Resource.ResourceInfoPullRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PULL_INFO, getCallOptions()), request);
    }

    /**
     * <pre>
     *拉取资源内容
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Resource.ResourceDataPullResponse> pullData(
        Resource.ResourceDataPullRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PULL_DATA, getCallOptions()), request);
    }

    /**
     * <pre>
     *推送资源信息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Resource.ResourceInfoPushResponse> pushInfo(
        Resource.ResourceInfoPushRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PUSH_INFO, getCallOptions()), request);
    }

    /**
     * <pre>
     *推送资源内容
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Resource.ResourceDataPushResponse> pushData(
        Resource.ResourceDataPushRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_PUSH_DATA, getCallOptions()), request);
    }
  }

  private static final int METHODID_PULL_INFO = 0;
  private static final int METHODID_PULL_DATA = 1;
  private static final int METHODID_PUSH_INFO = 2;
  private static final int METHODID_PUSH_DATA = 3;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ResourceServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(ResourceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PULL_INFO:
          serviceImpl.pullInfo((Resource.ResourceInfoPullRequest) request,
              (io.grpc.stub.StreamObserver<Resource.ResourceInfoPullResponse>) responseObserver);
          break;
        case METHODID_PULL_DATA:
          serviceImpl.pullData((Resource.ResourceDataPullRequest) request,
              (io.grpc.stub.StreamObserver<Resource.ResourceDataPullResponse>) responseObserver);
          break;
        case METHODID_PUSH_INFO:
          serviceImpl.pushInfo((Resource.ResourceInfoPushRequest) request,
              (io.grpc.stub.StreamObserver<Resource.ResourceInfoPushResponse>) responseObserver);
          break;
        case METHODID_PUSH_DATA:
          serviceImpl.pushData((Resource.ResourceDataPushRequest) request,
              (io.grpc.stub.StreamObserver<Resource.ResourceDataPushResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_PULL_INFO,
        METHOD_PULL_DATA,
        METHOD_PUSH_INFO,
        METHOD_PUSH_DATA);
  }

}
