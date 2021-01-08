package com.cache.service;

import com.cache.mapper.EmployeeMapper;
import com.cache.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/8 - 15:04
 */
public interface EmployeeService {
    Employee queryEmployeeById(Integer id);

    Employee updateEmployee(Employee employee);

    Object deleteEmployee(Integer id);

    Employee queryEmployeeByLastName(String lastName);
}
