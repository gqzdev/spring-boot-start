package com.gqz.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyAMQPConfig
 * @author: ganquanzhong
 * @date: 2019/10/18 17:00
 */

@Configuration
public class MyAMQPConfig {

    //配置Rabbitmq使用jackson的json序列化
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
