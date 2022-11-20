package com.uniktech.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniktech.user.config.UnikJmsProperties;
import com.uniktech.user.dto.UnikContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Component
@Slf4j
public class JmsService {

    @Value("${spring.application.name}")
    private String TOPIC;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    UnikJmsProperties unikJmsProperties;

    @Autowired
    JmsTemplate jmsTemplate;

    @JmsListener(destination = "${unik.jms-broker.in-queue}")
    @SendTo("${unik.jms-broker.out-queue}")
    public String receiveMessage(final Message jsonMessage) throws JMSException, JsonProcessingException {
        String messageData = null;
        log.info("Received message on UserService Queue - {}", jsonMessage);
        String response = null;
        if(jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)jsonMessage;
            messageData = textMessage.getText();
            response = objectMapper.writeValueAsString(new UnikContext(TOPIC, messageData));
        }
        return response;
    }

    public void sendMessage(String requestMessage) throws JsonProcessingException {
        log.info("inside sendMessage method of User-JmsService");
        jmsTemplate.convertAndSend(unikJmsProperties.getInQueue(), requestMessage);
    }
}
