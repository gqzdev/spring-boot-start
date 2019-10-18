package com.gqz.amqp;

import com.gqz.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootAmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    void contextLoads() {
        //使用rabbitTemplate发送message

        //Message需要自己构造一个；定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routingKey,message);

        //object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
        // rabbitTemplate.convertAndSend(exchange,rountingKey,object);
        Map<String ,Object> map = new HashMap<>();
        map.put("msg","这是甘全中发送的第一个rabbitMessage消息");
        map.put("data", Arrays.asList("hello world,json序列化操作",1996,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","gqz",map);
    }


    @Test
    public void testGetMessage(){
//        Message gqz = rabbitTemplate.receive("gqz");
//        System.out.println(gqz.toString());
//        System.out.println(gqz.getBody().toString());

        Object o = rabbitTemplate.receiveAndConvert("gqz");
        System.out.println(o.getClass());
        System.out.println(o);
    }


    //测试fanout策略  广播，分发到所有的队列queue
    @Test
    public void testRabbitFanout(){
        Book book = new Book("Spring Boot程序设计入门到实战123", "甘全中");
//        rabbitTemplate.convertAndSend("exchange.fanout","",book);

        rabbitTemplate.convertAndSend("exchange.direct","gqz",book);


    }

}
