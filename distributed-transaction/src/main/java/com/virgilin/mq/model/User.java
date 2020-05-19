package com.virgilin.mq.model;

import lombok.Data;

@Data
public class User {
    /**
     * 主键
     */
    private String id;
    /**
     * 用户名
     */
    private String userName;
}
