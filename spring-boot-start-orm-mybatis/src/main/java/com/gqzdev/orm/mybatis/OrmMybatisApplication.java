package com.gqzdev.orm.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot整合MyBatis
 *      在application.properties或yml中配置mybatis的映射文件mapper.xml ，别名，等
 *      添加@MapperScan注解，扫描mapper接口
 *
 * @Author: ganquanzhong
 * @Date:  2020/6/17 18:01
 */

@MapperScan(basePackages = {"com.gqzdev.orm.mybatis.mapper"})
@SpringBootApplication
public class OrmMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmMybatisApplication.class, args);
    }
}
