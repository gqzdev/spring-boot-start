package com.gqz.springbootcache.controller;

import com.gqz.springbootcache.bean.Employee;
import com.gqz.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: EmployeeController
 * @author: ganquanzhong
 * @date: 2019/10/10 15:31
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeService.getEmp(id);
    }
}

