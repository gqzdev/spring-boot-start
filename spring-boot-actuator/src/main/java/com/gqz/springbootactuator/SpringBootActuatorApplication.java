package com.gqz.springbootactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    自定义健康状态指示器
    1、编写一个指示器  实现 HealthIndicator接口
    2、指示器的名字规范  xxxxHealthIndicator
    3、加入到容器中生效
 */
@SpringBootApplication
public class SpringBootActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootActuatorApplication.class, args);

        System.out.println("monitor  监控 123");
    }

    /**
     * 相关actuator的endpoint说明
     * https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html
     * */



}
