package com.zeqinlin.MyCommunity.dao;

import com.zeqinlin.MyCommunity.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description:消息数据访问层接口
 * date: 2021/5/31 14:44
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Mapper
public interface MessageMapper {

    //查询当前用户的会话列表，针对每个会话只返回一条最新的私信
    List<Message> selectConversations(int userId, int offset, int limit);

    //查询当前用户的会话数量
    int selectConversationCount(int userId);

    //查询某个会话所包含的私信列表
    List<Message> selectLetters(String conversationId, int offset, int limit);

    //查询某个会话所包含的私信数量
    int selectLetterCount(String conversationId);

    //查询未读的私信的数量
    int selectLetterUnreadCount(int userId, String conversationId);
}