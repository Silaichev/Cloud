package com.silaichev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@Profile("cloud")*/
public class CloudLabApplication {


	public static void main(String[] args) {
		SpringApplication.run(CloudLabApplication.class, args);
	}

}
