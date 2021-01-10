package com.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author lijichen
 * @date 2021/1/10 - 21:11
 */
@Component
public class MyTestHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        Health.up().build();//表示开机状态
        return Health.down().withDetail("message","出错！！！").build();
    }
}
