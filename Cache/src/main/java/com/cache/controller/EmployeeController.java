package com.cache.controller;

import com.cache.pojo.Employee;
import com.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/8 - 15:01
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 可以获取缓存处理，进行缓存操作
     */
    @Qualifier(value = "jsonCacheManager")
    @Autowired
    private CacheManager cacheManager;

    @GetMapping("/jsonCacheManager")
    public Object jsonCacheManager() {
        Cache cache = cacheManager.getCache("emp"); // 缓存名
        cache.put("11111",employeeService.queryEmployeeById(1));
        Employee e = (Employee) cache.get("emp::11111");
        Employee employee = cache.get("11111", Employee.class);
        return "success:"+e+employee;
    }



    @GetMapping("/emp/{id}")
    public Object queryEmployee(@PathVariable("id") Integer id) {
        return employeeService.queryEmployeeById(id);
    }

    @GetMapping("/emp")
    public Object updateEmployee(Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @GetMapping("/deleteEmp/{id}")
    public Object updateEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        return "success";
    }

    @GetMapping("/empByLastName/{lastName}")
    public Object employee(@PathVariable("lastName") String lastName) {
        Employee employees = employeeService.queryEmployeeByLastName(lastName);
        return employees;
    }


}
