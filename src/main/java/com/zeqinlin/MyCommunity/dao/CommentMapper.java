package com.zeqinlin.MyCommunity.dao;

import com.zeqinlin.MyCommunity.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Description:评论数据的数据访问层
 * date: 2021/5/25 20:45
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Mapper
public interface CommentMapper {

    List<Comment> selectCommentByEntity(int entityType,int entityId,int offset,int limit);

    int selectCountByEntity(int entityType,int entityId);

    int insertComment(Comment comment);

    Comment selectCommentById(int id);


}
