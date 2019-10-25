package com.gqz.task.controller;

import com.gqz.task.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: AsyncController
 * @author: ganquanzhong
 * @date: 2019/10/25 15:17
 */

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello(){
        asyncService.hello(); //该方法用@Async标注为异步方法
        return "success";
    }
}
