package com.silaichev.cloud.controller;


import com.silaichev.cloud.pojo.Info;
import com.silaichev.cloud.service.InfoService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.silaichev.cloud.rabbit.RabbitConfiguration.EXCHANGE_NAME;

@RestController
public class MainController {

    @Autowired
    InfoService infoService;

    @Autowired
    private AmqpTemplate template;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/add")
    public String add(){
        Info info = new Info(0, "newInfo", "passForNewInfo");
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
        rabbitTemplate.convertAndSend(EXCHANGE_NAME,"", new Info(0,"newInfo","passForNewInfo"));
        return "all";
    }

}
