package com.silaichev.cloud.controller;


import com.silaichev.cloud.pojo.Info;
import com.silaichev.cloud.service.InfoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.silaichev.cloud.rabbit.RabbitConfiguration.EXCHANGE_NAME;

@RestController
public class MainController {

    @Autowired
    InfoService infoService;

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/add")
    public String add(@RequestBody Info info){
        System.out.println(info.toString());
        infoService.createInfo(info);
        return "hello";
    }

    @GetMapping("/get")
    public String get(){
        return infoService.getAllInfo().get(0).toString();
    }

    @GetMapping("/cloud")
    public String cloud(){
        template.convertAndSend("cloudQueue", new Info(0,"newInfo","passForNewInfo"));
        return "cloud";
    }

    @GetMapping("/microservice")
    public String microservice(){
        template.convertAndSend("microserviceQueue", new Info(0,"newInfo","passForNewInfo"));
        return "microservice";
    }

    @GetMapping("/all")
    public String all(){

        template.convertAndSend(EXCHANGE_NAME, "", "passForNewInfo");
        return "all";
    }

}
