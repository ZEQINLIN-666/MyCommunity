package com.zeqinlin.MyCommunity.dao;

import com.zeqinlin.MyCommunity.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 * date: 2021/5/3 22:14
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String username);

    User selectByEmail(String Email);

    int insertUser(User user);

    int updateStatus(int id,int status);

    int updateHeader(int id,String headerUrl);

    int updatePassword(int id,String password);

}
