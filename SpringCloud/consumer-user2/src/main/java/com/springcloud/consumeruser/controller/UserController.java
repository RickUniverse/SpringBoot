package com.springcloud.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijichen
 * @date 2021/1/10 - 19:37
 */
@RestController
public class UserController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/buy")
    public Object buy(String name) {
        String forObject = restTemplate.getForObject("http://PROVIDER-TICKET2/getTicket", String.class);
        return name + "获得了：" + forObject;
    }
}
