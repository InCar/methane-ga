package com.incarcloud.core;

/**
 * 采集器--接口
 * Created by sunjun on 2020/1/13.
 */
public abstract class Gather {

    /**
     * 启动采集器
     */
    public abstract void start();

    /**
     * 停止采集器
     */
    public abstract void stop();
}
