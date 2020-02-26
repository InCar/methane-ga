package com.incarcloud;

import org.junit.Test;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class MockClientTest {


    @Test
    public void getFile(){
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            String filePath = "/Users/liqi/Desktop";
            String fileName = "file.jpg";
            byte[] bfile = new byte[]{1};
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
}
