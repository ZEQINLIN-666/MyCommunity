package com.zeqinlin.MyCommunity.entity;

import lombok.Data;

import java.util.Date;

/**
 * Description:用来封装user数据的实体类
 * date: 2021/5/3 21:57
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private int type;
    private int status;
    private String activationCode;
    private String headerUrl;
    private Date createTime;

}
