package com.gqz.springboot.controller;

import com.gqz.springboot.dao.DepartmentDao;
import com.gqz.springboot.dao.EmployeeDao;
import com.gqz.springboot.entities.Department;
import com.gqz.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @ClassName: EmployeeController
 * @author: ganquanzhong
 * @date: 2019/9/16 15:11
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees = employeeDao.getAll();
        //放在请求域中
        model.addAttribute("emps",employees);

        //thymeleaf默认会拼接串
        //classpath:/template/xxx.html
        return "emp/list";
    }


    @GetMapping("/emp")
    public String toAddPage(Model model){
        //跳转到添加页面
        //查出所有的部门显示在下拉框
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }


    //员工添加
    //Spring MVC自动将请求参数和入参对象的属性进行绑定
    //要求请求参数的名字和javaBean入参的对象里面的属性名是一样
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        //添加员工
        employeeDao.save(employee);
        System.out.println("添加的员工信息："+employee.toString());
        //添加完成，来到员工列表页面
        //redirect:表示重定向到一地址
        //forward：表示转发到一个地址
        return "redirect:/emps";
    }

    //modify employee
    //获取修改数据和页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面要显示所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //回到修改页面（add是一个修改添加二合一的页面）
        return "emp/add";
    }

    //修改update
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        System.out.println("修改的employee数据"+employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";

    }

    //delete
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){


        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
