package com.uniktech.user.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "unik.jms-broker")
public class UnikJmsProperties {
    private String inQueue;
    private String outQueue;
    private String brokerUri;
}
