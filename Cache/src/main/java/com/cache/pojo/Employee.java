package com.cache.pojo;

import java.io.Serializable;

/**
 * @author lijichen
 * @date 2021/1/7 - 16:04
 */
public class Employee implements Serializable {
    private Integer id;
    private String lastName;
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
