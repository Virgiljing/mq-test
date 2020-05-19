package com.virgilin.mq.service;

import com.alibaba.fastjson.JSON;
import com.virgilin.mq.dao.UserDao;
import com.virgilin.mq.dao.UserEventDao;
import com.virgilin.mq.enums.EventProcess;
import com.virgilin.mq.enums.EventType;
import com.virgilin.mq.model.Event;
import com.virgilin.mq.model.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private UserEventService userEventService;

    @Transactional
    public void newUser(String userName,Integer pointAmount){
        //1.保存用户
        String userId = userDao.insert(userName);
        //2.新增事件
        Event event = new Event();
        event.setType(EventType.NEW_USER.getValue());
        event.setProcess(EventProcess.NEW.getValue());

        Point point = new Point();
        point.setUserId(userId);
        point.setAmount(pointAmount);
        //将对象转换成JSON字符串保存到事件表的content字段中
        event.setContent(JSON.toJSONString(point));
        userEventService.newEvent(event);
    }

}
