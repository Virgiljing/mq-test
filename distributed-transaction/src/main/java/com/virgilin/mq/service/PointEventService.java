package com.virgilin.mq.service;

import com.alibaba.fastjson.JSON;
import com.virgilin.mq.dao.PointEventDao;
import com.virgilin.mq.enums.EventProcess;
import com.virgilin.mq.enums.EventType;
import com.virgilin.mq.exception.BusinessException;
import com.virgilin.mq.model.Event;
import com.virgilin.mq.model.Point;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PointEventService {

    @Resource
    private PointEventDao pointEventDao;

    @Resource
    private PointService pointService;

    public int newEvent(Event event) {
        if (event != null) {
            return pointEventDao.insert(event);
        } else {
            throw new BusinessException("入参不能为空！");
        }
    }

    public List<Event> getPublishedEventList(){
        return pointEventDao.getByProcess(EventProcess.PUBLISHED.getValue());
    }

    public void executeEvent(Event event){
        if (event != null) {
            String process = event.getProcess();
            if (EventProcess.PUBLISHED.getValue().endsWith(process) && EventType.NEW_POINT.getValue().equals(event.getType())) {
                Point point = JSON.parseObject(event.getContent(), Point.class);
                pointService.newPoint(point);
                event.setProcess(EventProcess.PROCESSED.getValue());
                pointEventDao.updateProcess(event);
            }
        }
    }
}
