package com.virgilin.mq.service;

import com.virgilin.mq.dao.PointDao;
import com.virgilin.mq.model.Point;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PointService {

    @Resource
    private PointDao pointDao;

    public void newPoint(Point point) {
        pointDao.insert(point);
    }
}
