package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2020/12/30 - 19:40
 */
@RestController
public class TestController {

    @Value("${ymlbean.name}")
    private String name;

    @RequestMapping("/testValue")
    public Object testValue() {
        return "hello " + name;
    }
}
