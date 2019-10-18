package com.gqz.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring Boot集成Integration AMQP rabbitmq
 * 自动配置类RabbitAutoConfiguration
 * 1.自动配置了连接工厂 rabbitConnectionFactory
 * 2.RabbitProperties 封装了Rabbitmq的配置文件
 * 3.RabbitTemplate 给RabbitMQ发送和接收消息
 * 4.AmqpAdmin： RabbitMQ系统管理功能组件
 * 5. @EnableRabbit  + @RabbitListener 监听消息队列的内容
 *
 * @author ganquanzhong
 * @date   2019/10/18 14:54
 */

@EnableRabbit //开启基于注解的Rabbitmq模式
@SpringBootApplication
public class SpringBootAmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAmqpApplication.class, args);
    }

}
