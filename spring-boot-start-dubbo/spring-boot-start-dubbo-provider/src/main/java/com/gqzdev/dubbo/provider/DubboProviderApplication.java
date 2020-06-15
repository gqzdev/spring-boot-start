package com.gqzdev.dubbo.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用@EnableDubboConfiguration开启Dubbo
 * 配置注册中心
 *
 * @Author: ganquanzhong
 * @Date:  2020/6/15 13:26
 */

@EnableDubboConfiguration
@SpringBootApplication
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
