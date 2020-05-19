package com.virgilin.mqtest.activemq.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String text = textMessage.getText();
                System.out.println("主题监听器1接收到文本消息：" + text);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }else {
            throw new IllegalArgumentException("只支持 TextMessage类型消息！");
        }
    }
}
