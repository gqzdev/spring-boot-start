package com.gqz.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  eureka-server注册中心
 *  1.配置eureka信息
 *  2.@EnableEurekaServer开启服务注册发现
 */

@EnableEurekaServer  //开启eureka的服务注册功能
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
