package com.incarcloud.resource_1.structure.server.impl;

import com.incarcloud.resource_1.structure.data.ResourceFragment;
import com.incarcloud.resource_1.structure.data.ResourceInfo;
import com.incarcloud.resource_1.structure.server.ResourceStoreHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnMissingBean(ResourceStoreHandler.class)
public class EmptyResourceStoreHandler implements ResourceStoreHandler {
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
    public int put(String id, int start, int end,byte[] data) {
        return 0;
    }
}
