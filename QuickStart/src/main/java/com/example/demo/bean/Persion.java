package com.example.demo.bean;

/**
 * @author lijichen
 * @date 2020/12/30 - 18:40
 */
public class Persion {
    private String name;
    private int gender;

    public Persion() {
    }

    public Persion(String name, int gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Persion setName(String name) {
        this.name = name;
        return this;
    }

    public int getGender() {
        return gender;
    }

    public Persion setGender(int gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
