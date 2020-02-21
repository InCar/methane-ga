package com.incarcloud.resource_1;

import com.incarcloud.resource_1.structure.server.ServerResourceHandler;
import com.incarcloud.resource_1.structure.server.impl.EmptyServerResourceHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceConfig {
    @Bean
    @ConditionalOnMissingBean
    public ServerResourceHandler resourceStoreHandler(){
        return new EmptyServerResourceHandler();
    }
}
