package com.incarcloud.config.kafka;

import com.incarcloud.config.kafka.properties.KafkaProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class ProducerUtil {
    static KafkaProperties kafkaProperties;

    @Autowired
    public void setKafkaProperties(KafkaProperties kafkaProperties) {
        ProducerUtil.kafkaProperties = kafkaProperties;
    }

    public static Producer getProducer(){
        Properties props = new Properties();
        com.incarcloud.config.kafka.properties.Producer config=kafkaProperties.producer;
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, config.keySerializer);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, config.valueSerializer);
        props.put(ProducerConfig.ACKS_CONFIG, config.acks);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, config.batchSize);
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, config.compressionType);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, config.bufferMemory);
        Producer producer = new KafkaProducer(props);
        return producer;
    }
}
