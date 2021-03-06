package com.virgilin.mq.dao;

import com.virgilin.mq.model.Point;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.UUID;

@Repository
public class PointDao extends JdbcDaoSupport {

    public String insert(Point point){
        String id = UUID.randomUUID().toString().replace("-","");
        getJdbcTemplate().update("insert into t_point(id,user_id,amount) values (?,?,?)",(PreparedStatement ps)->{
            ps.setString(1,id);
            ps.setString(2,point.getUserId());
            ps.setInt(3,point.getAmount());
        });
        return id;
    }
}
