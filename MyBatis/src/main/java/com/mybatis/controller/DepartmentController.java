package com.mybatis.controller;

import com.mybatis.mapper.DepartmentMapper;
import com.mybatis.mapper.EmployeeMapper;
import com.mybatis.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijichen
 * @date 2021/1/7 - 16:22
 */
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Object getDept(@PathVariable("id") Integer id) {
        return departmentMapper.selectByIdDempartment(id);
    }

    /*@GetMapping("/dept")
    public Object getDeptAll() {
        return departmentMapper.selectAllDempartment();
    }*/

    @GetMapping("/dept")
    public Object updateDept(Department department) {
        departmentMapper.insertDepartment(department);
        return department;
    }


    @GetMapping("/emps")
    public Object getAllEmps() {
        return employeeMapper.selectAllEmployee();
    }
}
