package com.mystarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijichen
 * @date 2021/1/7 - 20:30
 */
@Configuration
@ConditionalOnWebApplication// web应用环境下才会生效，使用
@EnableConfigurationProperties(HelloProperties.class)//让HelloProperties生效, 就可以自动注入了, 不然不能@Autowired
public class HelloServiceAutoConfiguration {

    @Autowired
    HelloProperties helloProperties;

    @Bean
    @ConditionalOnMissingBean(HelloService.class)// 容器中没有这个Bean生效
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setHelloProperties(helloProperties);
        return helloService;
    }
}
