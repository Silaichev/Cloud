package com.silaichev.microservice.service;

import com.silaichev.microservice.entity.MicroserviceCredential;
import com.silaichev.microservice.repository.MicroserviceCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("microservice")
public class MicroserviceCredentialService {

    private static final String ID = "CredentialsId";

    @Autowired
    private MicroserviceCredentialsRepository credentialsRepository;

    public void create(String cloudPseudonym) {
        credentialsRepository.save(new MicroserviceCredential(ID, cloudPseudonym));
    }

    public boolean credentialsExists() {
        return credentialsRepository.findById(ID).isPresent();
    }
}
