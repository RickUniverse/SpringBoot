package com.cache.mapper;


import com.cache.pojo.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/7 - 17:03
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from tb_employee")
    List<Employee> selectAllEmployee();

    @Select("select * from tb_employee where id = #{id}")
    Employee selectOneByEmployeeId(Integer id);

    @Insert("insert into tb_employee(last_name,gender,email,dept_id) value(#{lastName},#{gender},#{email},#{deptId})")
    Employee insertEmployee(Employee employee);

    @Update("update tb_employee set last_name=#{lastName} where id = #{id}") //, gender=#{gender}, email=#{email}, dept_id=#{deptId}
    Integer updateEmployee(Employee employee);

    @Delete("delete from tb_employee where id = #{id}")
    Integer deleteEmployee(Integer id);

    @Select("select * from tb_employee where last_name = #{lastName}")
    Employee selectEmployeeByLastName(String lastName);
}
