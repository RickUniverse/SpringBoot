package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ImportResource: 指定外部xml配置文件,
 *      推荐使用配置类的方式! 使用@Bean进行注入
 */
// @ImportResource(locations = {"classpath:bean.xml"})
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
