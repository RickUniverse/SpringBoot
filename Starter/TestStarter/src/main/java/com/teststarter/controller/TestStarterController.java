package com.teststarter.controller;

import com.mystarter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/7 - 20:48
 */
@RestController
public class TestStarterController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/testStarter")
    public Object testStarter() {
        return helloService.sayHello("张三");
    }
}
