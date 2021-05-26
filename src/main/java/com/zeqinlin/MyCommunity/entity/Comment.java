package com.zeqinlin.MyCommunity.entity;

import lombok.Data;

import java.util.Date;

/**
 * Description:评论数据的实体类
 * date: 2021/5/25 20:47
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Data
public class Comment {
    private int id;
    private int userId;
    private int entityType;
    private int targetId;
    private int entityId;
    private String content;
    private int status;
    private Date createTime;


}
