package com.uniktech.persistor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "unik.jms-broker")
public class UnikJmsProperties {
    private String inQueue;
    private String brokerUri;
}
