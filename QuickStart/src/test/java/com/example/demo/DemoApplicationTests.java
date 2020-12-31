package com.example.demo;

import com.example.demo.bean.YmlBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    YmlBean ymlBean;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    void hasHelloSpringBoot() {
        System.out.println(applicationContext.containsBean("helloSpringBoot"));
    }

    @Test
    void contextLoads() {

        // 日志的级别从低到高
        logger.trace("这是trace最低级别");
        logger.debug("这是debug级别");
        // springboot 默认是info级别的
        logger.info("这是info级别");
        logger.warn("这是warn警告级别");
        logger.error("这是error错误级别");
        System.out.println(ymlBean);
    }

}
