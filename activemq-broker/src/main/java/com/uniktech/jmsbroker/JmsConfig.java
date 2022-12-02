package com.uniktech.jmsbroker;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UnikJmsProperties.class)
@Slf4j
public class JmsConfig {

    @Autowired
    private UnikJmsProperties unikJmsProperties;

    @Bean
    public BrokerService brokerService() throws Exception {
        return BrokerFactory.createBroker(unikJmsProperties.getBrokerUri(), true);
    }
}
