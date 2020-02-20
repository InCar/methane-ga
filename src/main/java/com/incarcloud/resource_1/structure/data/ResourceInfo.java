package com.incarcloud.resource_1.structure.data;

public class ResourceInfo {
    //资源标识符
    protected String id;
    //资源版本(若资源变动则版本累加)
    protected int version;
    //资源是否完整(若完整则只有一个片段)
    protected boolean complete;
    //资源碎片信息(包头不包尾)
    //完整的资源只包含一个碎片(例如大小为1kb资源表示为0-1024)
    //不完整的资源包含多个碎片(例如大小为1kb资源可能表示为0-10,10-100,120-200,500-1000,1000-1024)
    protected String fragment;

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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getFragment() {
        return fragment;
    }

    public void setFragment(String fragment) {
        this.fragment = fragment;
    }
}
