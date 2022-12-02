package com.uniktech.department.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="unik.jms-broker")
public class UnikJmsProperties {
    private String inQueue;
    private String outQueue;
    private String brokerUri;
}