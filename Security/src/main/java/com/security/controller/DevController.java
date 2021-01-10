package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/10 - 19:52
 */
@RestController
public class DevController {
    @GetMapping("/testDevssssss")
    public Object testDev() {
        String name = "www";
        return "testDssssev"+name;
    }
}
