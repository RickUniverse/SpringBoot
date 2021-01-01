package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/1 - 16:20
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session) {
        if ("admin".equals(username) && "123".equals(password)) {
            // 保存到session域中
            session.setAttribute("loginUser",username);
            return "redirect:/main.html"; // 重定向到main。html页面
        } else {
            map.put("msg","用户名或密码错误！");
            return "login.html";
        }
    }
}
