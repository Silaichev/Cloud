package com.silaichev.cloud.rabbit;

import com.silaichev.cloud.service.MicroserviceCredentialService;
import com.silaichev.cloud.service.MicroserviceRequestsRecognizerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("microservice")
public class MicroserviceLocalRabbitListener {

    @Autowired
    private MicroserviceRabbitConfiguration microserviceRabbitConfiguration;

    @Autowired
    private MicroserviceCredentialService credentialService;

    @Autowired
    private MicroserviceRequestsRecognizerService recognizerService;

    @RabbitListener(queues = "#{microserviceRabbitConfiguration.getMAC()}")
    public void processMicroservice(String message) {
        System.out.println(message);
        if (recognizerService.checkProcess(message)) {
            recognizerService.analyze(message);
        } else if (message.equals(microserviceRabbitConfiguration.getMAC())) {
            credentialService.create(message);
        }

    }

}
