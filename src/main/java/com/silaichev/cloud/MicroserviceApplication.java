package com.silaichev.cloud;

import com.silaichev.cloud.service.MicroserviceCredentialService;
import com.silaichev.cloud.service.MicroserviceRabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("microservice")
public class MicroserviceApplication {

	@Autowired
	private MicroserviceCredentialService credentialsService;

	@Autowired
	private MicroserviceRabbitService rabbitService;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceApplication.class, args);
	}

	@Bean
	public boolean init(){
		if(!credentialsService.credentialsExists()){
			rabbitService.initRequest();
		}
		return true;
	}
}
