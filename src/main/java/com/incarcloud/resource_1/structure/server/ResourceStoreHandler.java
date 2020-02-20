package com.incarcloud.resource_1.structure.server;

import com.incarcloud.resource_1.structure.data.ResourceInfo;
import com.incarcloud.resource_1.structure.data.ResourceFragment;

/**
 * 资源存储读取处理类
 */
public interface ResourceStoreHandler {
    /**
     * 根据资源id获取资源信息
     * @param id
     * @return
     */
    ResourceInfo get(String id);

    /**
     * 根据资源id和资源版本获取资源片段内容
     * @param id
     * @param version
     * @param start
     * @param end
     * @return 返回null表示资源片段不存在
     */
    ResourceFragment getFragment(String id,int version, int start,int end);

    /**
     * 创建新的资源
     * @return 返回null表示创建失败
     */
    String create();

    /**
     * 添加数据到资源中
     * @param id
     * @param start
     * @param data
     * @return (1:成功;2:资源不存在;3:推送的资源数据位置重复;3:其他失败原因)
     */
    int put(String id,int start,byte[] data);
}
