package com.jpa.controller;

import com.jpa.pojo.Employee;
import com.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/7 - 17:44
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/emp/{id}")
    public Object getEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeRepository.getOne(id);
        return employee;
    }

    @GetMapping("/emp")
    public Object saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }
}
