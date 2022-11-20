package com.uniktech.persistor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniktech.persistor.dto.UnikContext;
import com.uniktech.persistor.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Date;

@Component
@Slf4j
public class JmsService {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PersistorService persistorService;

    @JmsListener(destination = "${unik.jms-broker.in-queue}")
    public void receiveMessage(final Message jsonMessage) throws JMSException {
        String messageData = null;
        log.info("Received message on PersistorService Queue - {}", jsonMessage);
        String response = null;
        if(jsonMessage instanceof TextMessage) {
            TextMessage textMessage = (TextMessage)jsonMessage;
            messageData = textMessage.getText();
            try {
                log.info("messageData with context - {}", messageData);
                UnikContext context = objectMapper.readValue(messageData, UnikContext.class);
                if(context != null){
                    Transaction txn = persistorService.saveTransaction(new Transaction(null,context.getRequestTopic(),context.getRequestMessage(),new Date()));
                    if(txn != null) {
                        log.info("object saved successfully -- {}", txn.toString());
                    }
                }
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
