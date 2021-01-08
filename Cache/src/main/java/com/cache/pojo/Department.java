package com.cache.pojo;

import java.io.Serializable;

/**
 * @author lijichen
 * @date 2021/1/7 - 16:06
 */
public class Department implements Serializable {
    private Integer id;
    private String deptName;

    public Department() {
    }

    public Department(Integer id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }

    public Integer getId() {
        return id;
    }

    public Department setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getDeptName() {
        return deptName;
    }

    public Department setDeptName(String deptName) {
        this.deptName = deptName;
        return this;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
