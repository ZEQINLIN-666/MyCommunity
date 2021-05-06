package com.zeqinlin.MyCommunity.entity;

import lombok.Data;

import java.util.Date;

/**
 * Description:传递数据的实体类
 * date: 2021/5/4 15:15
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Data
public class DiscussPost {

    private int id;
    private int userId;
    private String title;
    private String content;
    private int type;
    private int status;
    private Date createTime;
    private int commentCount;
    private double score;
}
