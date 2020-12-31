package org.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lijichen
 * @date 2020/12/30 - 16:15
 */

/**
 * @SpringBootApplication : 来标注一个主程序类, 说明这是一个Spring boot应用
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {

        //启动Spring Boot
        SpringApplication.run(MainApplication.class);
    }
}
