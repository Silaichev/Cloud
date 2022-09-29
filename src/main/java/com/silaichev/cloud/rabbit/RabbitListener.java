package com.silaichev.cloud.rabbit;

import com.silaichev.cloud.pojo.Info;
import com.silaichev.cloud.rabbit.RabbitConfiguration;
import org.springframework.stereotype.Component;

@Component
public class RabbitListener {

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitConfiguration.CLOUD_QUEUE)
    public void processCloudQueue(Info message){
        System.out.println("Cloud "+message);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = RabbitConfiguration.MICROSERVICE_QUEUE)
    public void processMicroservice(Info message){
        System.out.println("Microservice "+message);
    }

}
