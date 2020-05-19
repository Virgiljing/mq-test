package com.virgilin.mqtest.activemq.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-activemq.xml");
        MessageService messageService = (MessageService) applicationContext.getBean("messageService");
        messageService.sendQueueMessage("我的测试消息1");
        messageService.sendTopicMessage("我的测试消息2");
        messageService.sendTopicMessage("我的测试消息3");
    }
}
