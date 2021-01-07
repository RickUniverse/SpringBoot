package com.jpa.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.Arrays;

/**
 * @author lijichen
 * @date 2021/1/7 - 19:24
 */
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner..run"+ Arrays.asList(args));
    }
}
