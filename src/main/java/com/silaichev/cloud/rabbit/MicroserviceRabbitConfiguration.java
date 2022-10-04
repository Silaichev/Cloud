package com.silaichev.cloud.rabbit;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("microservice")
public class MicroserviceRabbitConfiguration {

    public String MAC = System.getenv("MAC");
    public static final String CLOUD_QUEUE = "cloudQueue";

    @Bean
    public Queue cloudQueue() {
        return new Queue(CLOUD_QUEUE);
    }

    @Bean
    public Queue myQueue() {
        return new Queue(System.getenv("MAC"));
    }

    public String getMAC() {
        return MAC;
    }
}
