package com.jpa.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * jpa实体类配置
 * @author lijichen
 * @date 2021/1/7 - 16:04
 */
@Entity // 告诉jpa这是一个实体类
@Table(name = "tb_jpa_employee")// 映射的表
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"}) // 需要使用此注解准换为json字符串
public class Employee {

    @Id// 这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "last_name",length = 50)//跟数据库表对应的字段
    private String lastName;
    @Column //省略默认列明就是属性名
    private Integer gender;
    private String email;

    public Employee() {
    }

    public Employee(Integer id, String lastName, Integer gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public Employee setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
