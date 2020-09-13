package com.gqzdev.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName Application
 * @Description
 * @Author ganquanzhong
 * @Date 2020/9/12 23:30
 * @Version
 **/

@SpringBootApplication
@MapperScan(basePackages = "com.gqzdev.mybatisplus.mapper")
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }
}
