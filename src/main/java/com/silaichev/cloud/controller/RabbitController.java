package com.silaichev.cloud.controller;

import com.silaichev.cloud.pojo.Info;
import com.silaichev.cloud.rabbit.RabbitConfiguration;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitController {

    @RabbitListener(queues = RabbitConfiguration.CLOUD_QUEUE)
    public void processCloudQueue(Info message){
        System.out.println("Cloud "+message);
    }

    @RabbitListener(queues = RabbitConfiguration.MICROSERVICE_QUEUE)
    public void processMicroservice(Info message){
        System.out.println("Microservice "+message);
    }

}
