package com.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author lijichen
 * @date 2021/1/9 - 21:03
 */
@Service
public class AsyncService {

    @Async//这是一个异步方法
    public void sayHello() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
    }
}
