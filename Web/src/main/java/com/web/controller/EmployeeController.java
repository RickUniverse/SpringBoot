package com.web.controller;

import com.web.dao.DepartmentDao;
import com.web.dao.EmployeeDao;
import com.web.entities.Employee;
import com.web.exception.UserNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lijichen
 * @date 2021/1/1 - 21:00
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public Object emps() {
        ModelAndView modelAndView = new ModelAndView("emp/list");
        modelAndView.addObject("emps",employeeDao.getAll());
        return modelAndView;
    }

    @GetMapping("/emp")
    public Object emp(Model model) {

        Map<String,Object> map = new HashMap<>();
        map.put("depts",departmentDao.getDepartments());
        model.addAllAttributes(map);

        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{empid}")
    public Object editEmp(@PathVariable("empid") Integer id, Model model) {

        Map<String,Object> map = new HashMap<>();
        map.put("depts",departmentDao.getDepartments());
        map.put("emp",employeeDao.get(id));
        model.addAllAttributes(map);

        return "emp/add";
    }

    @PutMapping("/emp")
    public Object updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }


//    @DeleteMapping("/emp/{eid}")
    @RequestMapping(value = "/emp/{eid}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("eid") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    @RequestMapping("/testException")
    public String testException(@RequestParam("user") String user) {

        if ("111".equals(user)) {
            throw new UserNotFindException();
        }
        return "redirect:/emps";
    }
}
