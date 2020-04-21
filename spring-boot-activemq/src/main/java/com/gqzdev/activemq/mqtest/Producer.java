package com.gqzdev.activemq.mqtest;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMapMessage;

import javax.jms.*;

/**
 * @ClassName: Producer
 * @author: ganquanzhong
 * @date: 2020/4/21 16:36
 */
public class Producer {

    public static void main(String[] args) throws JMSException {
        //创建连接工厂  tcp协议
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("tcp://tx.ganquanzhong.top:61616");

        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();

        //启动连接
        connection.start();

        //创建会话
        /**
         *  参数  是否使用事务
         */
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        // 纯文本内容
//        //创建队列
//        Queue queue = session.createQueue("gqzdev");
//
//        //创建生产者
//        MessageProducer producer = session.createProducer(queue);
//
//        //生成消息  Message
//        ActiveMQTextMessage message = new ActiveMQTextMessage();
//        message.setText("加油！！ 多积累");

        //Map Message
        //创建队列
        Queue queue = session.createQueue("orders");

        //创建生产者
        MessageProducer producer = session.createProducer(queue);

        //生成消息  Message
        ActiveMQMapMessage activeMQMapMessage = new ActiveMQMapMessage();
        activeMQMapMessage.setInt("orderId",2002020212);
        activeMQMapMessage.setString("result","ok");

        //发送消息
        producer.send(activeMQMapMessage);
        //关闭 资源
        producer.close();
        session.close();
        connection.close();
    }
}
