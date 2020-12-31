package com.example.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lijichen
 * @date 2020/12/30 - 18:39
 */
@Component// 表示是一个组件
/**
 * @ConfigurationProperties : 表示映射配置文件中的数据
 *      prefix: 表示映射文件中的数据的key
 */
@ConfigurationProperties(prefix = "ymlbean")
/**
 * 导入指定的配置文件
 */
//@PropertySource(value = {"classpath:dbconfig.properties"})
@Validated
public class YmlBean {

    //@Value("${ymlbean.name}") // 从配置文件中获取
    @Email
    //@Value("${jdbc.username}")
    private String name;
    //@Value("#{3 + 4}")// #{} 是spring表达式
    private Integer age;

    //@Value("false") // 设置字面量
    private Boolean flag;
    private Date time;

    private Persion persion;
    private Map<String,Object> map;
    private List<Persion> list;

    public YmlBean() {
    }

    public String getName() {
        return name;
    }

    public YmlBean setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public YmlBean setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Boolean getFlag() {
        return flag;
    }

    public YmlBean setFlag(Boolean flag) {
        this.flag = flag;
        return this;
    }

    public Date getTime() {
        return time;
    }

    public YmlBean setTime(Date time) {
        this.time = time;
        return this;
    }

    public Persion getPersion() {
        return persion;
    }

    public YmlBean setPersion(Persion persion) {
        this.persion = persion;
        return this;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public YmlBean setMap(Map<String, Object> map) {
        this.map = map;
        return this;
    }

    public List<Persion> getList() {
        return list;
    }

    public YmlBean setList(List<Persion> list) {
        this.list = list;
        return this;
    }

    @Override
    public String toString() {
        return "YmlBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", flag=" + flag +
                ", time=" + time +
                ", persion=" + persion +
                ", map=" + map +
                ", list=" + list +
                '}';
    }
}
