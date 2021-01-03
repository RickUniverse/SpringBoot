package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author lijichen
 * @date 2020/12/31 - 18:35
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/testController")
    public Object testController() {
        return new Date();
    }

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(Map<String, Object> map) {
        map.put("thymeleaf","thymeleaf.html，经过thymeleaf模板解析-");
        map.put("users", Arrays.asList("qqq","www","<h1>eee</h1>"));
        return "thymeleaf";
    }
}
