package com.incarcloud.resource_1.structure.client;

import java.nio.file.Path;

/**
 * 模拟客户端
 */
public interface MockClient {
    /**
     * 下载文件到路径下
     * @param id
     * @param path
     */
    void download(String id,Path path);

    /**
     * 上传本地文件到服务器
     * @param path
     * @return
     */
    String upload(Path path);
}
