package com.gqz.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 *  注解@EnableAsync开启异步任务的支持
 *
 * @author ganquanzhong
 * @date   2019/10/25 15:26
 */


@EnableAsync  //开启异步任务
@EnableScheduling  //开启定时任务
@SpringBootApplication
public class SpringBootTaskApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTaskApplication.class, args);

        System.out.println(context);
    }

}
