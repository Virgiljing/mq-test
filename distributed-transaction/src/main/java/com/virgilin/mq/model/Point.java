package com.virgilin.mq.model;

import lombok.Data;

@Data
public class Point {
    /**
     * 主键
     */
    private String id;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 积分金额
     */
    private Integer amount;
}
