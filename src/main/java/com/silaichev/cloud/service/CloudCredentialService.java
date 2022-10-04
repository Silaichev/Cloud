package com.silaichev.cloud.service;

import com.silaichev.cloud.entity.CloudCredential;
import com.silaichev.cloud.repository.CloudCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Profile("cloud")
public class CloudCredentialService {

    @Autowired
    private DBSequenceService dbSequenceService;

    @Autowired
    private CloudCredentialRepository credentialRepository;

    public String createCredential(String mac){
        return credentialRepository.save(new CloudCredential(dbSequenceService.incrementSequence(),mac)).getMac();
    }

    public List<String> getQueueNames(){
        List<String> queuesNames = new LinkedList<>();
        credentialRepository.findAll().forEach(credential -> queuesNames.add(credential.getMac()));
        return queuesNames;
    }

    public boolean checkMac(String  mac){
        return getQueueNames().contains(mac);
    }

}
