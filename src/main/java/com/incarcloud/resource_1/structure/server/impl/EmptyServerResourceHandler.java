package com.incarcloud.resource_1.structure.server.impl;

import com.incarcloud.resource_1.structure.data.ResourceFragment;
import com.incarcloud.resource_1.structure.data.ResourceInfo;
import com.incarcloud.resource_1.structure.server.ServerResourceHandler;

public class EmptyServerResourceHandler implements ServerResourceHandler {
    @Override
    public ResourceInfo get(String id) {
        return null;
    }

    @Override
    public ResourceFragment getFragment(String id, int version, int start, int end) {
        return null;
    }

    @Override
    public String create() {
        return null;
    }

    @Override
    public int put(String id, int start,byte[] data) {
        return 0;
    }
}
