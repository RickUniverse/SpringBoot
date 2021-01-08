package com.cache.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lijichen
 * @date 2021/1/8 - 16:30
 */
@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")// 自定义的缓存 key 生成策略
    public KeyGenerator keyGenerator() {
        return new KeyGenerator(){

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName() + "("+ Arrays.asList(objects) +")";
            }
        };
    }
}
