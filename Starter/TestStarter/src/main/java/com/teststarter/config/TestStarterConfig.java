package com.teststarter.config;

import com.mystarter.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijichen
 * @date 2021/1/7 - 21:01
 */
@Configuration
public class TestStarterConfig {

    //测试 @ConditionalOnMissingBean(HelloService.class) 成功
    /*@Bean
    public HelloService helloService() {
        return new HelloService();
    }*/
}
