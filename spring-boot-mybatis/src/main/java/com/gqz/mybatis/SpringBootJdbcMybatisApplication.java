package com.gqz.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//MapperScan 批量扫描
@MapperScan("com.gqz.mybatis.mapper")
@SpringBootApplication
public class SpringBootJdbcMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJdbcMybatisApplication.class, args);
    }

}
