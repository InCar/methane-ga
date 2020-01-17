package com.incarcloud.core;

import com.incarcloud.std.HelloV;

/**
 * 采集器处理通道--tcp实现
 * Created by sunjun on 2020/1/13.
 */
public abstract class GatherChannelTCP{

    /**
     * 读取从tcp中获取到的原始数据
     */
    public abstract void doChannel(HelloV helloV);
}
