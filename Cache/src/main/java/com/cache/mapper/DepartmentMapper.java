package com.cache.mapper;

import com.cache.pojo.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lijichen
 * @date 2021/1/7 - 16:17
 */
//@Mapper
public interface DepartmentMapper {

    @Select("select * from tb_department")
    List<Department> selectAllDempartment();

    @Select("select * from tb_department where id = #{id}")
    Department selectByIdDempartment(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into tb_department(dept_name) value(#{deptName})")
    Integer insertDepartment(Department department);
}
