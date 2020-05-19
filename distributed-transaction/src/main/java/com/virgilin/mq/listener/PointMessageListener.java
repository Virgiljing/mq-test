package com.virgilin.mq.listener;

import com.virgilin.mq.enums.EventProcess;
import com.virgilin.mq.enums.EventType;
import com.virgilin.mq.exception.BusinessException;
import com.virgilin.mq.model.Event;
import com.virgilin.mq.service.PointEventService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class PointMessageListener implements MessageListener {

    @Resource
    private PointEventService pointEventService;
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                TextMessage txtMsg = (TextMessage) message;
                String eventContent = txtMsg.getText();
                System.out.println("队列监听器接收到文本消息：" + eventContent);
                if (!StringUtils.isEmpty(eventContent)) {
                    Event event = new Event();
                    event.setType(EventType.NEW_POINT.getValue());
                    event.setProcess(EventProcess.PUBLISHED.getValue());
                    event.setContent(eventContent);
                    pointEventService.newEvent(event);
                }
            } catch (JMSException e) {
                throw new BusinessException("接收消息处理过程错误！");
            }
        }else {
            throw new IllegalArgumentException("只支持TextMessage类型消息！");
        }
    }
}
