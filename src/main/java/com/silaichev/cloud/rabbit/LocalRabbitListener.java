package com.silaichev.cloud.rabbit;

import com.silaichev.cloud.service.CredentialService;
import com.silaichev.cloud.service.RabbitService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LocalRabbitListener {

    @Value("${init.message}")
    private String REFERENCE_INIT;

    @Autowired
    private RabbitConfiguration rabbitConfiguration;

    @Autowired
    private RabbitService rabbitService;

    @Autowired
    private CredentialService credentialService;

    @RabbitListener(queues = RabbitConfiguration.CLOUD_QUEUE)
    public void processCloudQueue(String message) {

        if (message.contains(REFERENCE_INIT)) {
            String mac = message.replace(REFERENCE_INIT, "");

            if(!credentialService.checkMac(mac)){
                credentialService.createCredential(mac);
                rabbitService.sendToDestination(mac, mac);
            }
        }
    }
}
