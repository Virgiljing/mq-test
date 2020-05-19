package com.virgilin.mqtest.rabbitmq.async;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Business {

    //用户注册
    public void userRegister(){
        /**
         * 校验用户填写的信息是否完成
         * 将用户及相关信息保存到数据库
         * 注册成功后发送一条消息表示要发送邮件
         */

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("async-context.xml");
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        Mail mail = new Mail();
        mail.setTo("1234567890@qq.com");
        mail.setSubject("我是一封邮件");
        mail.setContent("我的邮件内容");
        template.convertAndSend(mail);
        context.close();
    }

    public static void main(String[] args) {
        Business business = new Business();
        business.userRegister();
    }
}
