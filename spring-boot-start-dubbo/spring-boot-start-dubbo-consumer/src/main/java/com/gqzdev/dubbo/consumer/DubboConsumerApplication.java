package com.gqzdev.dubbo.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  使用@EnableDubboConfiguration 开启Dubbo使用
 *
 *  配置ZooKeeper注册中心
 *
 * @Author: ganquanzhong
 * @Date:  2020/6/15 13:18
 */

@SpringBootApplication
@EnableDubboConfiguration
public class DubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }
}
