package com.silaichev.cloud.rabbit;

import com.silaichev.cloud.entity.Info;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LocalRabbitListener {

    /*@RabbitListener(queues = RabbitConfiguration.CLOUD_QUEUE)
    public void processCloudQueue(Info info){
        System.out.println("Cloud info "+info);
    }*/

/*
    @RabbitListener(queues = RabbitConfiguration.MICROSERVICE_QUEUE)
    public void processMicroservice(Info info){
        System.out.println("Microservice info "+info);
    }
*/

    /*@RabbitListener(queues = RabbitConfiguration.MICROSERVICE_QUEUE)
    public void processMicroservice(String message){
        System.out.println("Microservice message "+message);
    }*/

}
