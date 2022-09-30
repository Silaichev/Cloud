package com.silaichev.cloud.rabbit;


import com.silaichev.cloud.service.CredentialService;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@Configuration
public class RabbitConfiguration {

    @Autowired
    private CredentialService credentialService;

    public static final String CLOUD_QUEUE = "cloudQueue";
    public List<String> queuesNames;

    @Bean
    public List<Queue> creatingQueues() {
        queuesNames = credentialService.getQueueNames();
        List<Queue> queuesList = new LinkedList<>();
        return queuesList;
    }
}
