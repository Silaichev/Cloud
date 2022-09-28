package com.silaichev.cloud.rabbit;


import org.springframework.amqp.core.*;
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
    public Queue getCloudQueue() {
        return new Queue(CLOUD_QUEUE);
    }

    @Bean
    public Queue getMicroserviceQueue() {
        return new Queue(MICROSERVICE_QUEUE);
    }
/*
    @Bean
    public FanoutExchange fanoutBindings() {
        Queue fanoutQueue1 = new Queue(CLOUD_QUEUE, false);
        Queue fanoutQueue2 = new Queue(MICROSERVICE_QUEUE, false);
        FanoutExchange fanoutExchange = new FanoutExchange(EXCHANGE_NAME);

        BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
        BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
        return fanoutExchange;

    }*/

   /* @Bean
    public Declarables fanoutBindings() {
        Queue fanoutQueue1 = new Queue(CLOUD_QUEUE, false);
        Queue fanoutQueue2 = new Queue(MICROSERVICE_QUEUE, false);
        FanoutExchange fanoutExchange = new FanoutExchange(EXCHANGE_NAME);

        return new Declarables(
                fanoutQueue1,
                fanoutQueue2,
                fanoutExchange,
                BindingBuilder.bind(fanoutQueue1).to(fanoutExchange),
                BindingBuilder.bind(fanoutQueue2).to(fanoutExchange));
    }*/

}
