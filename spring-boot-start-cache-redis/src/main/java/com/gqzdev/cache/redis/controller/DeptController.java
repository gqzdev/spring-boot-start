package com.gqzdev.cache.redis.controller;


import com.gqzdev.cache.redis.bean.Department;
import com.gqzdev.cache.redis.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DeptController
 * @Description
 * @Author ganquanzhong
 * @Date2019/10/16 22:50
 * @Version
 **/
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("dept/{id}")
    public Department getDept(@PathVariable("id") Integer id){
        return deptService.getDeptById(id);
    }
}
