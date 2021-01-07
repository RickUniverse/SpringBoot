package com.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/6 - 22:18
 */
@Controller
public class HelloConrtroller {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/hello")
    public Object hello() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tb_employee");
        return maps;
    }
}
