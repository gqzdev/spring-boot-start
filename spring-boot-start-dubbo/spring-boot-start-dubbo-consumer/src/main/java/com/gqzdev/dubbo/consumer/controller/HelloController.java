package com.gqzdev.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gqzdev.dubbo.common.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello服务API
 * @Author: ganquanzhong
 * @Date:  2020/6/15 13:25
 */

@RestController
@Slf4j
public class HelloController {

    /**
     *  使用@Reference注解   远程调用
     *  就像使用本地的service一样
     */
    @Reference
    private HelloService helloService;

    @GetMapping("/sayHello")
    public String sayHello(@RequestParam(defaultValue = "gqzdev") String name) {
        log.info("i'm ready to call someone......");
        return helloService.sayHello(name);
    }
}
