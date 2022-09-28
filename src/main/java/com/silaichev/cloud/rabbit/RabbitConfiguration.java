package com.silaichev.cloud.rabbit;


import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

import static org.springframework.amqp.core.BindingBuilder.bind;


@Configuration
public class RabbitConfiguration {

    public static final String CLOUD_QUEUE = "cloudQueue";

    public static final String MICROSERVICE_QUEUE = "microserviceQueue";

    public static final String EXCHANGE_NAME = "all";

    @Bean
    public Queue getCloudQueue(){
        return new Queue(CLOUD_QUEUE);
    }

    @Bean
    public Queue getMicroserviceQueue(){
        return new Queue(MICROSERVICE_QUEUE);
    }

}
