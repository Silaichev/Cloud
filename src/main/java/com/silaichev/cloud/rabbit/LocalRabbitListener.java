package com.silaichev.cloud.rabbit;

import com.silaichev.cloud.service.CredentialService;
import com.silaichev.cloud.service.RabbitService;
import com.silaichev.cloud.service.RequestsRecognizerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LocalRabbitListener {

    @Value("${init.message}")
    private String REFERENCE_INIT;

    @Autowired
    private RabbitService rabbitService;

    @Autowired
    private CredentialService credentialService;

    @Autowired
    private RequestsRecognizerService recognizerService;

    @RabbitListener(queues = RabbitConfiguration.CLOUD_QUEUE)
    public void processCloudQueue(String message) {

        if (message.contains(REFERENCE_INIT)) {
            String mac = message.replace(REFERENCE_INIT, "");

            if(!credentialService.checkMac(mac)){
                credentialService.createCredential(mac);
                rabbitService.sendToDestination(mac, mac);
                rabbitService.sendToDestination(mac, recognizerService.backupMessage());
            }
        }
    }
}
