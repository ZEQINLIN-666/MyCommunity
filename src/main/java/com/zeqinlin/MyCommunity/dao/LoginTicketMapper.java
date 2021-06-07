package com.zeqinlin.MyCommunity.dao;

import com.zeqinlin.MyCommunity.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

/**
 * Description:
 * date: 2021/5/14 14:25
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Mapper
@Deprecated //不推荐使用该方法了
public interface LoginTicketMapper {
    @Insert({"insert into login_ticket(user_id,ticket,status,expired) ",
            "value(#{userId},#{ticket},#{status},#{expired})"
    })
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({"select user_id,ticket,status,expired ",
            "from login_ticket ",
            "where ticket = #{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({"update login_ticket set status=#{status} " ,
            "where ticket = #{ticket}"
    })
    int updateStatus(String ticket,int status);
}

