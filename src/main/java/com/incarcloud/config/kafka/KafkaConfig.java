package com.incarcloud.config.kafka;

import com.incarcloud.config.kafka.properties.Consumer;
import com.incarcloud.config.kafka.properties.KafkaProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConfig {

    @Autowired
    KafkaProperties kafkaProperties;

    @Bean("consumerProperties")
    public Properties consumerProperties(){
        Properties props = new Properties();
        Consumer config=kafkaProperties.consumer;
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, config.groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, config.keyDeserializer);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, config.valueDeserializer);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, config.enableAutoCommit);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, (int)config.autoCommitInterval.toMillis());
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, (int)config.heartbeatInterval.toMillis());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, config.autoOffsetReset);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, (int)config.sessionTimeout.toMillis());
        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, (int)config.requestTimeout.toMillis());
        props.put(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, config.maxPartitionFetchBytes);
        return props;
    }
}
