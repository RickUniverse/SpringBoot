package com.jpa.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author lijichen
 * @date 2021/1/7 - 19:25
 */
@Component//CommandLineRunner 和 ApplicationRunner 需要使用component声明加入到容器中
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner..run"+ Arrays.asList(args));
    }
}
