package com.silaichev.cloud.service;

import com.silaichev.cloud.entity.Credential;
import com.silaichev.cloud.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CredentialService {

    @Autowired
    private DBSequenceService dbSequenceService;

    @Autowired
    private CredentialRepository credentialRepository;

    public String createCredential(String mac){
        return credentialRepository.save(new Credential(dbSequenceService.incrementSequence(),mac)).getMac();
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
