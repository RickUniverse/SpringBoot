package com.example.demo.config;

import com.example.demo.bean.HelloSpringBoot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijichen
 * @date 2020/12/30 - 20:12
 */
@Configuration
public class TestConfig {

    @Bean
    public HelloSpringBoot helloSpringBoot() {
        return new HelloSpringBoot();
    }
}
