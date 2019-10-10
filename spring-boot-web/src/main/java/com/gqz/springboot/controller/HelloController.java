package com.gqz.springboot.controller;

import com.gqz.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * @title: HelloContoller
 * @author: ganquanzhong
 * @create: 2019-06-13 18:08
 **/

@Controller
public class HelloController {
//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "index";
//    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("user") String user){
        if (user.equals("aaa")){
            throw new UserNotExistException();
        }

        return "Hello World!";
    }

    @RequestMapping("/success")
    public String success(Map<String ,Object> map){
        //访问路径 classpath:/templates/success.html
        map.put("hello","<h1>甘全中您好！</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
