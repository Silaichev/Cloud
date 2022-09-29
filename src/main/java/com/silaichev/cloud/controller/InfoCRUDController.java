package com.silaichev.cloud.controller;


import com.google.gson.Gson;
import com.silaichev.cloud.entity.Info;
import com.silaichev.cloud.service.InfoService;
import com.silaichev.cloud.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("info")
public class InfoCRUDController {

    @Autowired
    private RabbitService rabbitService;

    @Autowired
    private InfoService infoService;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Info info) {
        infoService.createInfo(info);
        rabbitService.sendToAll(new Gson().toJson(info));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Info[] info) {
        infoService.editInfo(info);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Info info) {
        infoService.delete(info);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/read")
    public ResponseEntity<List<Info>> read() {
        return new ResponseEntity<>(infoService.getAllInfo(),HttpStatus.OK);
    }

}
