package com.cache;

import com.cache.pojo.Department;
import com.cache.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;

@SpringBootTest
class CacheApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Qualifier("myRedisTemplate")
    @Autowired
    private RedisTemplate myRedisTemplate;//转为json字符串

//    @Autowired
////    private RedisTemplate jsonRedisTemplate;//转为json字符串

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testRedis() {
        stringRedisTemplate.opsForValue().append("msg","opsForValueAppend");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    void testObjectJson() {
        myRedisTemplate.opsForList().leftPush("emps01",Arrays.asList(new Employee(1,"qwe",1,"sdfsd")
                ,new Employee(1,"qwe",1,"sdfsd")));
        myRedisTemplate.opsForList().leftPush("emps01",Arrays.asList(new Employee(1,"qwe",1,"sdfsd")
                ,new Employee(1,"qwe",1,"sdfsd")));
        myRedisTemplate.opsForList().leftPush("emps01",Arrays.asList(new Employee(1,"qwe",1,"sdfsd")
                ,new Employee(1,"qwe",1,"sdfsd")));


        myRedisTemplate.opsForList().leftPush("depart",Arrays.asList(new Department(1,"wer")
                ,new Department(1,"wer")  ));
        myRedisTemplate.opsForList().leftPush("depart",Arrays.asList(new Department(1,"wer")
                ,new Department(1,"wer")  ));
        myRedisTemplate.opsForList().leftPush("depart",Arrays.asList(new Department(1,"wer")
                ,new Department(1,"wer")  ));


    }
//    @Test
//    void testObjectJson2() {
//        jsonRedisTemplate.opsForList().leftPush("emps01",Arrays.asList(new Employee(1,"qwe",1,"sdfsd")
//                ,new Employee(1,"qwe",1,"sdfsd")));
//        jsonRedisTemplate.opsForList().leftPush("emps01",Arrays.asList(new Employee(1,"qwe",1,"sdfsd")
//                ,new Employee(1,"qwe",1,"sdfsd")));
//        jsonRedisTemplate.opsForList().leftPush("emps01",Arrays.asList(new Employee(1,"qwe",1,"sdfsd")
//                ,new Employee(1,"qwe",1,"sdfsd")));
//    }


    @Test
    void contextLoads() {
    }

}
