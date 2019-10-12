package com.gqz.springbootcache;

import com.gqz.springbootcache.bean.Employee;
import com.gqz.springbootcache.bean.User;
import com.gqz.springbootcache.mapper.EmployeeMapper;
import com.gqz.springbootcache.utils.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheDemoApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    public void contextLoads() {

        Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee.toString());

    }

    @Test
    public void getUser(){
        ApplicationContext applicationContext = SpringUtils.getApplicationContext();
        User user = (User) applicationContext.getBean("user");
        System.out.println(user.toString());
    }

    @Test
    public void getUser1(){
        System.out.println(((User) SpringUtils.getObject("user")).toString());
    }

    @Test
    public void getUser2(){

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(User.class);
        System.out.println("spring上下文"+applicationContext);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println(name);
        }


    }




}
