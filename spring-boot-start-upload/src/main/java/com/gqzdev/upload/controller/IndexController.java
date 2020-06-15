package com.gqzdev.upload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页Controller
 * @Author: ganquanzhong
 * @Date:  2020/6/15 15:27
 */

@Controller
public class IndexController {
    @GetMapping("")
    public String index() {
        return "index";
    }
}
