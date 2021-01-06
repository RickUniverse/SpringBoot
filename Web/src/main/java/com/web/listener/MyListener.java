package com.web.listener;

import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletRequestEvent;

/**
 * @author lijichen
 * @date 2021/1/5 - 14:04
 */
public class MyListener extends RequestContextListener {
    public MyListener() {
        System.out.println("RequestContextListener监听器创建..");
    }

    @Override
    public void requestInitialized(ServletRequestEvent requestEvent) {
        System.out.println("RequestContextListener监听器初始化..");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent requestEvent) {
        System.out.println("RequestContextListener监听器销毁..");
    }
}
