package com.springbootwar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lijichen
 * @date 2021/1/5 - 16:06
 */
@Controller
public class TestController {

    @GetMapping("/success")
    public String success(Model model) {
        model.addAttribute("msg","hello");
        return "success";
    }
}
