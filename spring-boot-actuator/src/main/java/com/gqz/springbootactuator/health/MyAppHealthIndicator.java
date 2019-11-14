package com.gqz.springbootactuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @ClassName MyAppHealthIndicator
 * @Description   通过实现HealthIndicator接口实现自定义健康指标
 * @Author ganquanzhong
 * @Date2019/11/14 22:41
 * @Version
 **/

@Component
public class MyAppHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        /*
            自定义的检查方法
         */
        //Health.up().build(); //代表健康
        return Health.down().withDetail("msg","服务异常").build(); //down代表异常
    }
}
