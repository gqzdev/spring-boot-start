package com.gqzdev.activemq.mqtest;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ClassName: Consumer
 * @author: ganquanzhong
 * @date: 2020/4/21 17:06
 */
public class Consumer {
    public static void main(String[] args) throws JMSException {

        //创建连接工厂
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://tx.ganquanzhong.top:61616");

        //创建连接
        Connection connection = factory.createConnection();

        //启动连接
        connection.start();

        //创建会话
        /**
         *  事务
         */

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建队列
//        Queue queue = session.createQueue("gqzdev");
//
//        //创建消费者
//        MessageConsumer consumer = session.createConsumer(queue);
//
//        //获取信息   消费
//        /**
//         *  创建监听  主动的轮询
//         */
//        consumer.setMessageListener(new MessageListener() {
//
//            @Override
//            public void onMessage(Message message) {
//                //判断message类型
//                if (message instanceof TextMessage){
//                    try {
//                        String text = ((TextMessage) message).getText();
//                        System.out.println("获取消息队列activemq中的消息---》"+text);
//                    } catch (JMSException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        });


        //Map类型
        Queue queue = session.createQueue("orders");

        //创建消费者
        MessageConsumer consumer = session.createConsumer(queue);

        //获取信息   消费
        /**
         *  创建监听  主动的轮询
         */
        consumer.setMessageListener(new MessageListener() {

            @Override
            public void onMessage(Message message) {
                //判断message类型
                if (message instanceof MapMessage){
                    try {
                        int orderId = ((MapMessage) message).getInt("orderId");
                        String result = ((MapMessage) message).getString("result");

                        System.out.println("--Map--"+orderId+"  "+result);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }

            }
        });



        //关闭资源  注意！！！！  需要主动轮询
//        consumer.close();
//        session.close();
//        connection.close();
    }

}
