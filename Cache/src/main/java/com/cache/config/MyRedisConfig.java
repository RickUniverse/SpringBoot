package com.cache.config;

import com.cache.pojo.Employee;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

/**
 * @author lijichen
 * @date 2021/1/8 - 21:22
 */
@Configuration
//@EnableCaching
public class MyRedisConfig {

    // 可转换为json的序列化器
    // 可以将pojo 对象转为json字符串
    @Bean
    public RedisTemplate<Object, Object> myRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    /**
     * 使用jdk序列化
     * 实体类必须有无参构造方法？
     * @return
     */
    @Primary// 如果有多个CacheManager必须指定默认使用哪一个， 该值是默认的
    @Bean
    public CacheManager jdkCacheManager(RedisConnectionFactory redisConnectionFactory) {
        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1)) // 设置缓存有效期一小时
                .disableCachingNullValues()
                //.disableKeyPrefix()//不要加这个加上会导致不能使用如cacheNames = "emp" 会失效， 只有键和值
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer())) //key需要是可以直接转换为字符串的，应该
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(jdkSerializationRedisSerializer))// 使用jdk序列化value值（对象）
                ;
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }
    /**
     * 使用json字符串缓存的CacheManager
     * @return
     */
    @Bean
    public CacheManager jsonCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofHours(1)) // 设置缓存有效期一小时ss
                .disableCachingNullValues()
                .serializeKeysWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new StringRedisSerializer())) //key
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer())) // 使用json转换value值（对象）
                ;
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();
    }


}
