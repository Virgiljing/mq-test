package com.virgilin.mq.task;

import com.virgilin.mq.model.Event;
import com.virgilin.mq.service.PointEventService;
import com.virgilin.mq.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class PointScheduled {

    @Autowired
    private PointEventService pointEventService;

    @Scheduled(cron = "*/5 * * * * *")
    public void executeEvent(){
        List<Event> eventList = pointEventService.getPublishedEventList();
        if (!CollectionUtils.isEmpty(eventList)) {
            System.out.println("已发布的积分事件记录总数：" + eventList.size());

            for (Event event : eventList) {
                pointEventService.executeEvent(event);
            }
        }else {
            System.out.println("待处理的事件总数：0");
        }
    }
}
