package com.elastic.config;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author lijichen
 * @date 2021/1/9 - 19:17
 */
@Configuration
public class JestClientConfig {

    /**
     * springboot2.3.0之后不支持自动注册，只能手动写注册配置文件.
     */
    @Bean
    public io.searchbox.client.JestClient jestClient() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("http://192.168.1.109:9200")
                .multiThreaded(true)
                .build());
        return factory.getObject();
    }

}
