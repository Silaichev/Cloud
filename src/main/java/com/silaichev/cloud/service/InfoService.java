package com.silaichev.cloud.service;


import com.silaichev.cloud.pojo.Info;
import com.silaichev.cloud.repo.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepo infoRepo;

    public void createInfo(Info info){
        infoRepo.save(info);
    }

    public List<Info> getAllInfo(){
        return infoRepo.findAll();
    }
}
