package com.virgilin.mqtest.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicPublisher {
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
        //创建连接工厂
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
            MessageProducer producer = session.createProducer(topic);

            for (int i = 0; i <= 3; i++) {
                TextMessage textMessage = session.createTextMessage("发送消息：" + i);
                producer.send(textMessage);
            }

            //关闭资源
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
