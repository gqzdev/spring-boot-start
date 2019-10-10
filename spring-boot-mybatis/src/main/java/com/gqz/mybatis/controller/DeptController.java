package com.gqz.mybatis.controller;

import com.gqz.mybatis.bean.Department;
import com.gqz.mybatis.bean.Employee;
import com.gqz.mybatis.mapper.DepartmentMapper;
import com.gqz.mybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DeptController
 * @author: ganquanzhong
 * @date: 2019/9/30 16:55
 */

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insetDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}

