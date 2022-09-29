package com.silaichev.cloud.service;


import com.silaichev.cloud.pojo.Info;
import com.silaichev.cloud.repo.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InfoService {

    @Autowired
    private DBSequenceService dbSequenceService;

    @Autowired
    private InfoRepo infoRepo;

    public void createInfo(Info info) {
        if (!checkExist(info)) {
            info.setId(dbSequenceService.incrementSequence());
            infoRepo.save(info);
        }
    }

    public void delete(Info info){
        if(checkExist(info)){
            Info deletingInfo = findInfoByName(info.getName());
            infoRepo.deleteById(deletingInfo.getId());
        }
    }

    public void editInfo(Info[] info) {
        if (checkExist(info[0])) {
            Info oldInfo = findInfoByName(info[0].getName());
            oldInfo.setName(info[1].getName());
            oldInfo.setPass(info[1].getPass());
            infoRepo.save(oldInfo);
        }
    }

    public Info findInfoByName(String name) {
        List<Info> filteredInfo = infoRepo.findAll().stream().filter(i -> i.getName().equals(name))
                .collect(Collectors.toList());
        return filteredInfo.get(0);
    }

    public boolean checkExist(Info info) {
        List<Info> filteredInfo = infoRepo.findAll().stream().filter(i -> i.getName().equals(info.getName()))
                .filter(i -> i.getPass().equals(info.getPass())).collect(Collectors.toList());
        return !filteredInfo.isEmpty();
    }

    public List<Info> getAllInfo() {
        return infoRepo.findAll();
    }
}
