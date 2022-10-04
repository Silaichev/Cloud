package com.silaichev.microservice.config;

import com.silaichev.microservice.service.MicroserviceCredentialService;
import com.silaichev.microservice.service.MicroserviceRabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("microservice")
public class RabbitConfiguration {

    @Autowired
    private MicroserviceCredentialService credentialsService;

    @Autowired
    private MicroserviceRabbitService rabbitService;

    @Bean
    public boolean init(){
        if(!credentialsService.credentialsExists()){
            rabbitService.initRequest();
        }
        return true;
    }
}
