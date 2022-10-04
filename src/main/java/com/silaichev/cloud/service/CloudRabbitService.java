package com.silaichev.cloud.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Profile("cloud")
public class CloudRabbitService {

    @Autowired
    private CloudCredentialService credentialService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToAll(String message) {
        credentialService.getQueueNames().forEach(name->sendToDestination(name, message));
    }

    public void sendToDestination(String destination, String message){
        rabbitTemplate.send(destination, new Message(message.getBytes(StandardCharsets.UTF_8)));
    }
}
