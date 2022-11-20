package com.uniktech.department.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

@EnableJms
@EnableConfigurationProperties({ActiveMQProperties.class, UnikJmsProperties.class})
@Configuration
public class JmsConfig {

    @Autowired
    private UnikJmsProperties unikJmsProperties;

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        return activeMQConnectionFactory;
    }

    @Bean
    public Destination inQueueDestination(){
        return new ActiveMQQueue(unikJmsProperties.getInQueue());
    }

    @Bean
    public Destination outQueueDestination(){
        return new ActiveMQQueue(unikJmsProperties.getOutQueue());
    }

}
