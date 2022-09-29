package com.silaichev.cloud.rabbit;


import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class RabbitConfiguration {

    public static final String CLOUD_QUEUE = "cloudQueue";
    public static final String MICROSERVICE_QUEUE = "microserviceQueue";
    public static final String SERVER_QUEUE = "serverQueue";
    public static final String EXCHANGE_NAME = "all";
    public static final List<String> queuesNames = Arrays.asList(MICROSERVICE_QUEUE, SERVER_QUEUE);

    @Bean
    public List<Queue> creatingQueuesAndFanout() {
        List<Queue> queuesList = new ArrayList<>();
        queuesNames.forEach(queueName -> queuesList.add(new Queue(queueName)));
        FanoutExchange fanoutExchange = new FanoutExchange(EXCHANGE_NAME);
        queuesList.forEach(queue -> BindingBuilder.bind(queue).to(fanoutExchange));
        return queuesList;
    }

}
