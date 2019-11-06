package com.gqz.consumeruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: UserController
 * @author: ganquanzhong
 * @date: 2019/11/6 17:28
 */

@RestController
public class UserController {

    //RestTemplate封装类
    //https://blog.csdn.net/limingcai168/article/details/82836772

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/buy")
    public String  buyTicket(String name){
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://PROVIDER-TICKET/order?name={1}", String.class,name);
        return responseEntity.getBody();
    }
}
