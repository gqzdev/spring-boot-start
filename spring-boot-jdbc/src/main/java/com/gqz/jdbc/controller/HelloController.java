package com.gqz.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: HelloController
 * @author: ganquanzhong
 * @date: 2019/9/30 13:42
 */

@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @ResponseBody
    @GetMapping("/user")
    public List<Map<String ,Object>> get(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from user");
        return list;
    }
}
