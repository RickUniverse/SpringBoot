package com.web.controller;

import com.web.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author lijichen
 * @date 2021/1/1 - 21:00
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public Object emps() {
        ModelAndView modelAndView = new ModelAndView("emp/list");
        modelAndView.addObject("emps",employeeDao.getAll());
        return modelAndView;
    }
}
