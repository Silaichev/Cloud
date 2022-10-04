package com.silaichev.cloud.controller;


import com.silaichev.common.entity.Info;
import com.silaichev.common.service.InfoService;
import com.silaichev.cloud.service.CloudRabbitService;
import com.silaichev.cloud.service.CloudRequestsRecognizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
@Profile("cloud")
public class InfoCRUDController {

    @Autowired
    private CloudRequestsRecognizerService recognizerService;

    @Autowired
    private CloudRabbitService rabbitService;

    @Autowired
    private InfoService infoService;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Info info) {
        infoService.createInfo(info);
        rabbitService.sendToAll(recognizerService.createInfoMessage(info));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Info[] infos) {
        infoService.editInfo(infos);
        rabbitService.sendToAll(recognizerService.editMessage(infos));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Info info) {
        infoService.delete(info);
        rabbitService.sendToAll(recognizerService.deleteMessage(info));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Info>> read() {
        return new ResponseEntity<>(infoService.getAllInfo(),HttpStatus.OK);
    }

}
