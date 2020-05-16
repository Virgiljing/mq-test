package com.virgilin.mqtest.rabbitmq.spring;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;

public class SendMessage {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        template.convertAndSend("Hello World");
        context.close();
    }
}
