package com.gqz.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @ClassName: BookService
 * @author: ganquanzhong
 * @date: 2019/10/18 17:35
 */

@Service
public class BookService {

   /* //使用@RabbitListener   监听消息队列中的消息
    @RabbitListener(queues="gqz.top")
    public void receive(Book book){
        System.out.println("收到了消息"+book);
    }*/


    //Message对象 可以获取到消息的详细信息
    @RabbitListener(queues ="gqz" )
    public void receive01(Message message){
        System.out.println("收到了消息");
        System.out.println("message.getBody()"+message.getBody());
        System.out.println("message.getMessageProperties()"+message.getMessageProperties());
        System.out.println("message.toString()"+message.toString());
    }
}
