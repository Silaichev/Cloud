package com.silaichev.cloud.controller;


import com.silaichev.cloud.pojo.Info;
import com.silaichev.cloud.service.InfoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.silaichev.cloud.rabbit.RabbitConfiguration.EXCHANGE_NAME;

@RestController
@RequestMapping("info")
public class InfoCRUDController {

    @Autowired
    private InfoService infoService;


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Info info) {
        infoService.createInfo(info);
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
