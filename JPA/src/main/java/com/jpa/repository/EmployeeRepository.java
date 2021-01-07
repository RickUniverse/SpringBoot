package com.jpa.repository;

import com.jpa.pojo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lijichen
 * @date 2021/1/7 - 17:36
 */
// 继承JpaRepository 可以进行crud，分页等操作
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
