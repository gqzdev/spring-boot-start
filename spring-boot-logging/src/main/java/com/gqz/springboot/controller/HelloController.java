package com.gqz.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: HelloController
 * @author: ganquanzhong
 * @create: 2019-06-10 17:29
 **/
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "helloworld,This is first SpringBoot";
    }
}
