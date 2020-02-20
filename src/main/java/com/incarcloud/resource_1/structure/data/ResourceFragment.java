package com.incarcloud.resource_1.structure.data;

public class ResourceFragment {
    //片段所属资源id
    private String id;
    //片段所属资源版本
    private int version;
    //片段内容开始位置(包括)
    private int begin;
    //片段内容结束位置(不包括)
    private int end;
    //片段内容
    private byte[] content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
