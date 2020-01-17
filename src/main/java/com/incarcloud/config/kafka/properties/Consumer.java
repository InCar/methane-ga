package com.incarcloud.config.kafka.properties;

import java.time.Duration;

public class Consumer {
    public String bootstrapServers;
    public String groupId;
    public String keyDeserializer;
    public String valueDeserializer;
    public Boolean enableAutoCommit;
    public Duration autoCommitInterval;
    public String autoOffsetReset;
    public Duration heartbeatInterval;
    public Duration sessionTimeout;
    public Duration requestTimeout;
    public Integer maxPartitionFetchBytes;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getKeyDeserializer() {
        return keyDeserializer;
    }

    public void setKeyDeserializer(String keyDeserializer) {
        this.keyDeserializer = keyDeserializer;
    }

    public String getValueDeserializer() {
        return valueDeserializer;
    }

    public void setValueDeserializer(String valueDeserializer) {
        this.valueDeserializer = valueDeserializer;
    }

    public Boolean getEnableAutoCommit() {
        return enableAutoCommit;
    }

    public void setEnableAutoCommit(Boolean enableAutoCommit) {
        this.enableAutoCommit = enableAutoCommit;
    }

    public Duration getAutoCommitInterval() {
        return autoCommitInterval;
    }

    public void setAutoCommitInterval(Duration autoCommitInterval) {
        this.autoCommitInterval = autoCommitInterval;
    }

    public String getAutoOffsetReset() {
        return autoOffsetReset;
    }

    public void setAutoOffsetReset(String autoOffsetReset) {
        this.autoOffsetReset = autoOffsetReset;
    }

    public Duration getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public void setHeartbeatInterval(Duration heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public Duration getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(Duration requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public Integer getMaxPartitionFetchBytes() {
        return maxPartitionFetchBytes;
    }

    public void setMaxPartitionFetchBytes(Integer maxPartitionFetchBytes) {
        this.maxPartitionFetchBytes = maxPartitionFetchBytes;
    }
}
