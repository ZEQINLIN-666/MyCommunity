package com.zeqinlin.MyCommunity.service;

import com.zeqinlin.MyCommunity.dao.UserMapper;
import com.zeqinlin.MyCommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:提供根据id查询用户的服务
 *              比如我们在查询帖子时，返回的userId只是id形式存在，不能体现完整的信息。
 * date: 2021/5/4 16:15
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User finaUserById(int id){
        return userMapper.selectById(id);
    }
}
