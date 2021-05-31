package com.zeqinlin.MyCommunity.entity;

import lombok.Data;

import java.util.Date;

/**
 * Description:聊天会话实体
 * date: 2021/5/31 14:42
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Data
public class Message {
    private int id;
    private int fromId;
    private int toId;
    private String conversationId;
    private String content;
    private int status;
    private Date createTime;
}
