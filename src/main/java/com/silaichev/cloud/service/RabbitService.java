package com.silaichev.cloud.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.silaichev.cloud.rabbit.RabbitConfiguration.EXCHANGE_NAME;

@Service
public class RabbitService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToAll(String message) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", message);
    }
}
