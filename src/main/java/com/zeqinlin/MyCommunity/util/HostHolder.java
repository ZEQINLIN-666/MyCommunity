package com.zeqinlin.MyCommunity.util;

import com.zeqinlin.MyCommunity.entity.User;
import org.springframework.stereotype.Component;

import java.lang.management.ThreadInfo;

/**
 * Description:持有用户的信息，用于替代session对象
 * date: 2021/5/14 17:25
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Component
public class HostHolder {
    private ThreadLocal<User> users = new ThreadLocal<>();

    public void setUser(User user){
        users.set(user);
    }

    public User getUser(){
        return users.get();
    }

    public void clear(){
        users.remove();
    }
}
