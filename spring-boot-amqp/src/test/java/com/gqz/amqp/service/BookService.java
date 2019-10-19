package com.gqz.amqp.service;

import com.gqz.amqp.bean.Book;
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

    //使用@RabbitListener   监听消息队列中的消息
    @RabbitListener(queues="gqz.top")
    public void receive(Book book){
        System.out.println("收到了消息"+book);
    }


    //Message对象 可以获取到消息的详细信息
    @RabbitListener(queues = "gqz")
    public void receveGqz(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
