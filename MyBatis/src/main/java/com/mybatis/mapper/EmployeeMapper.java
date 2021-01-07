package com.mybatis.mapper;

import com.mybatis.pojo.Employee;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/7 - 17:03
 */
public interface EmployeeMapper {
    List<Employee> selectAllEmployee();
}
