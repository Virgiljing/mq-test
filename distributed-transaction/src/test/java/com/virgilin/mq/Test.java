package com.virgilin.mq;

import com.virgilin.mq.service.UserService;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    private ApplicationContext context;

    @Before
    public void setUp(){
        context = new ClassPathXmlApplicationContext("application.xml");
    }

    @org.junit.Test
    public void newUser() throws InterruptedException {
        UserService userService = (UserService) context.getBean("userService");
        userService.newUser("测试",1500);
        Thread.sleep(10000);
    }
}
