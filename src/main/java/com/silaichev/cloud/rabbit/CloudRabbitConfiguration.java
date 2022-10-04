package com.silaichev.cloud.rabbit;


import com.silaichev.cloud.service.CloudCredentialService;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.LinkedList;
import java.util.List;


@Configuration
@Profile("cloud")
public class CloudRabbitConfiguration {

    @Autowired
    private CloudCredentialService credentialService;

    public static final String CLOUD_QUEUE = "cloudQueue";
    public List<String> queuesNames;

    @Bean
    public List<Queue> creatingQueues() {
        queuesNames = credentialService.getQueueNames();
        List<Queue> queuesList = new LinkedList<>();
        return queuesList;
    }
}
