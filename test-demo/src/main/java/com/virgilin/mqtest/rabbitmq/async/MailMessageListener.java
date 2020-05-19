package com.virgilin.mqtest.rabbitmq.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MailMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String body = new String(message.getBody());
        ObjectMapper mapper = new ObjectMapper();
        try {
            Mail mail = mapper.readValue(body, Mail.class);
            System.out.println("接收到邮件消息：" + mail);
            sendEmail(mail);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    private void sendEmail(Mail mail) {
        //调用JavaMail API 发送邮件
    }
}
