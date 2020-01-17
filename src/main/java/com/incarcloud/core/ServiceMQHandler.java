package com.incarcloud.core;

import com.incarcloud.std.HelloV;

/**
 * 业务处理逻辑
 * Created by sunjun on 2020/1/13.
 */
public abstract class ServiceMQHandler {

    /**
     * 数据经过简单处理通过kafka后发送给P
     */
    public abstract void doService(HelloV.HelloRequestV1 request);
}
