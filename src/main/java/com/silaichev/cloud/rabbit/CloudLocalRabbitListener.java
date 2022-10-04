package com.silaichev.cloud.rabbit;

import com.silaichev.cloud.service.CloudCredentialService;
import com.silaichev.cloud.service.CloudRabbitService;
import com.silaichev.cloud.service.CloudRequestsRecognizerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cloud")
public class CloudLocalRabbitListener {

    @Value("${init.message}")
    private String REFERENCE_INIT;

    @Autowired
    private CloudRabbitService rabbitService;

    @Autowired
    private CloudCredentialService credentialService;

    @Autowired
    private CloudRequestsRecognizerService recognizerService;

    @RabbitListener(queues = CloudRabbitConfiguration.CLOUD_QUEUE)
    public void processCloudQueue(String message) {
        System.out.println(message);
        if (message.contains(REFERENCE_INIT)) {
            String mac = message.replace(REFERENCE_INIT, "");
            System.out.println(!credentialService.checkMac(mac));
            if(!credentialService.checkMac(mac)){
                credentialService.createCredential(mac);
                rabbitService.sendToDestination(mac, mac);
                rabbitService.sendToDestination(mac, recognizerService.backupMessage());
            }
        }
    }
}
