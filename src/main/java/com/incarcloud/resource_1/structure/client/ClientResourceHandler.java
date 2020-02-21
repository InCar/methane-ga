package com.incarcloud.resource_1.structure.client;

/**
 * 资源存储读取处理类
 */
public interface ClientResourceHandler {
    /**
     * 创建一个资源
     * @param id
     * @return 创建是否成功
     */
    boolean create(String id);

    /**
     * 获取一个资源内容
     * @param id
     * @param start
     * @param end
     * @return
     */
    byte[] get(String id,int start,int end);

    /**
     * 添加内容到资源中
     * @param id
     * @param start
     * @param end
     * @param data
     * @return (1:成功;2:资源内容已存在;3:失败)
     */
    int put(String id,int start,int end,byte[] data);
}
