package com.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author lijichen
 * @date 2021/1/9 - 21:20
 */
@Service
public class ScheduledService {

    @Scheduled(cron = "0-4 * * * * MON-SAT")// 从周一到周六，每分钟前0-4，每秒执行一次
    public void scheduled() {
        System.out.println("hello。。。");
    }
}
