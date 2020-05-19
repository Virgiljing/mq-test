package com.virgilin.mq.model;

import lombok.Data;

import java.util.Date;

@Data
public class Event {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 事件类型
     */
    private String type;
    /**
     * 事件过程
     */
    private String process;
    /**
     * 事件内容
     */
    private String content;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
