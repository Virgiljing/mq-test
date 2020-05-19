package com.virgilin.mq.service;

import com.virgilin.mq.dao.UserEventDao;
import com.virgilin.mq.enums.EventProcess;
import com.virgilin.mq.exception.BusinessException;
import com.virgilin.mq.model.Event;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.List;

@Service
public class UserEventService {

    @Resource
    private UserEventDao userEventDao;

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "topicDistributedTransaction")
    private Destination topic;

    public int newEvent(Event event) {
        if (event != null) {
            return userEventDao.insert(event);
        }else {
            throw new BusinessException("入参不能为空！");
        }
    }
    public List<Event> getNewEventList(){
        return userEventDao.getByProcess(EventProcess.NEW.getValue());
    }

    public void executeEvent(Event event){
        if (event != null) {
            String process = event.getProcess();
            if (EventProcess.NEW.getValue().endsWith(process)) {
                String content = event.getContent();
                jmsTemplate.send(topic,(Session session)->{
                    TextMessage msg = session.createTextMessage();
                    msg.setText(content);
                    return msg;
                });
                event.setProcess(EventProcess.PUBLISHED.getValue());
                userEventDao.updateProcess(event);
            }
        }
    }
}
