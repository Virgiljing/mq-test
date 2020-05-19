package com.virgilin.mqtest.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicSubcriber {
    /**
     * 默认用户名
     */
    public static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    /**
     * 默认密码
     */
    public static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    /**
     * 默认连接地址
     */
    public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        //创建工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKER_URL);

        try {
            //创建连接
            Connection connection = connectionFactory.createConnection();
            //开启连接
            connection.start();

            //创建会话，不需要事务
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //创建主题
            Topic topic = session.createTopic("activemq-topic-test1");
            MessageConsumer consumer1 = session.createConsumer(topic);
            consumer1.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println("消费者1接收到消息：" + ((TextMessage)message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });


            MessageConsumer consumer2 = session.createConsumer(topic);
            consumer2.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println("消费者2接收到消息：" + ((TextMessage)message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            MessageConsumer consumer3 = session.createConsumer(topic);
            consumer3.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println("消费者3接收到消息：" + ((TextMessage)message).getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            Thread.sleep(100*1000);
            session.close();
            connection.close();
        } catch (JMSException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
