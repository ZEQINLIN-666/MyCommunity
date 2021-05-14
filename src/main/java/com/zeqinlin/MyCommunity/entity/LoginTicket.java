package com.zeqinlin.MyCommunity.entity;

import lombok.Data;

import java.util.Date;

/**
 * Description:封装登陆凭证的实体类
 * date: 2021/5/14 14:20
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Data
public class LoginTicket {

    private int id;
    private int userId;
    private String ticket;
    private int status;
    private Date expired;
}
