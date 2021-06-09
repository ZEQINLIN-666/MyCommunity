package com.zeqinlin.MyCommunity.service;

import com.zeqinlin.MyCommunity.dao.CommentMapper;
import com.zeqinlin.MyCommunity.dao.DiscussPostMapper;
import com.zeqinlin.MyCommunity.entity.Comment;
import com.zeqinlin.MyCommunity.util.CommunityConstant;
import com.zeqinlin.MyCommunity.util.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

/**
 * Description:评论查询的业务访问层
 * date: 2021/5/25 20:58
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Service
public class CommentService implements CommunityConstant {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<Comment> findCommentByEntity(int entityType, int entityId, int offset, int limit){
        return commentMapper.selectCommentByEntity(entityType,entityId,offset,limit);
    }

    public int findCountByEntity(int entityType,int entityId){
        return commentMapper.selectCountByEntity(entityType,entityId);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int addComment(Comment comment){
        if(comment == null){
            throw new IllegalArgumentException("参数不能为空");
        }

        //敏感词过滤
        comment.setContent(HtmlUtils.htmlEscape(comment.getContent()));
        comment.setContent(sensitiveFilter.filter(comment.getContent()));

        int rows = commentMapper.insertComment(comment);

        //更新帖子的评论数量（例如：回帖 18），评论的回复数不需要统计
        if(comment.getEntityType() == ENTITY_TYPE_POST){
            int count = commentMapper.selectCountByEntity(comment.getEntityType(), comment.getEntityId());
            discussPostMapper.updateCommentCount(comment.getEntityId(),count);
        }
        return rows;

    }

    public Comment findCommentById(int id){
        return commentMapper.selectCommentById(id);
    }
}
