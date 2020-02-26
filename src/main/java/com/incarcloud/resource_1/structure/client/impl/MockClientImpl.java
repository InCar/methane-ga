package com.incarcloud.resource_1.structure.client.impl;

import com.google.protobuf.ByteString;
import com.incarcloud.resource_1.std.Resource;
import com.incarcloud.resource_1.std.ResourceServiceGrpc;
import com.incarcloud.resource_1.std.impl.ResourceService;
import com.incarcloud.resource_1.structure.client.MockClient;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
public class MockClientImpl implements CommandLineRunner,MockClient {

    Logger logger = LoggerFactory.getLogger(MockClientImpl.class);

    @Autowired
    private ResourceService resourceService;

    @Override
    public void run(String... args) throws Exception {
        ServerBuilder.forPort(8888).addService(resourceService).build().start();
    }


    @Override
    public void download(String id, Path path) {
        //1、建立连接
        ManagedChannel _channel = ManagedChannelBuilder.forAddress("127.0.0.1",8888).usePlaintext().build();
        ResourceServiceGrpc.ResourceServiceBlockingStub _blcok = ResourceServiceGrpc.newBlockingStub(_channel);
        //2、获取资源信息
        Resource.ResourceInfoPullRequest pullRequest = Resource.ResourceInfoPullRequest.newBuilder().setId(id).build();
        Resource.ResourceInfoPullResponse response = _blcok.pullInfo(pullRequest);
        logger.info("---pullInfoResponse[{}]---",response.getCode());
        //3、根据fragment属性进行拆分
        String fragment = response.getFragment();
        //判断fragment拥有的碎片信息
        String[] arr = fragment.split(",");
        List<byte[]> list = new ArrayList<>(arr.length);
        for (String fra:arr){
            String[] fraArr = fra.split("-");

            Resource.ResourceDataPullRequest pullDataRequest = Resource.ResourceDataPullRequest.newBuilder().
                    setStart(Integer.valueOf(fraArr[0])).
                    setEnd(Integer.valueOf(fraArr[1])).build();
            Resource.ResourceDataPullResponse dataPullResponse = _blcok.pullData(pullDataRequest);
            ByteString data = dataPullResponse.getData();
            list.add(data.toByteArray());
        }
        int size = 0;
        //4、资源合并
        for (byte[] bytes : list) {
            size+=bytes.length;
        }
        byte[] bytes = new byte[size];
        for (byte[] b : list) {
            System.arraycopy(b, 0, bytes, 0, b.length);
        }
        //5、将byte[]写成文件
        String filePath = path.getRoot().toAbsolutePath().toString();
        String fileName = path.getFileName().toString();
        getFile(bytes,filePath,fileName);
    }


    /**
     * 根据byte数组，生成文件
     * filePath  文件路径
     * fileName  文件名称（需要带后缀，如*.jpg、*mp4、*.xml）
     */
    public void getFile(byte[] bfile, String filePath,String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if(!dir.exists() && !dir.isDirectory()){//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public String upload(Path path) {
        return null;
    }


}
