package com.gqz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: Hello
 * @author: ganquanzhong
 * @date: 2019/9/19 11:45
 */

@Controller
public class Hello {

    @GetMapping("/login")
    public String hello(Model model){
        System.out.println("正在请求login");
        model.addAttribute("user","ganquanzhong,hello world");
        return "/success";
    }

}
