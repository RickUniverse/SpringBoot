package com.web.controller;

import com.web.exception.UserNotFindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/4 - 20:29
 */
@ControllerAdvice//处理错误的handler
public class MyExceptionHandler {
    /*@ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFindException.class)
    public Map<String,Object> handlerException() {
        Map<String,Object> map = new HashMap<>();
        map.put("code","444");
        map.put("message","未找到");
        return map;
    }*/

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFindException.class)
    public String handlerException(Exception e, HttpServletRequest request) {

        //设置失败状态吗
        request.setAttribute("javax.servlet.error.status_code",500); //状态码不能是字符串

        Map<String,Object> map = new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",e.getMessage());
        return "forward:/error";
    }
}
