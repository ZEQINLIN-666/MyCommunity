package com.zeqinlin.MyCommunity.dao;

import com.zeqinlin.MyCommunity.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:与DiscussPost表交互的Mapper
 * date: 2021/5/4 15:32
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Mapper
public interface DiscussPostMapper {

    /**
     * 查询帖子的详细信息。
     * @param userId    对应生成动态sql，当没有拼接user_id时，将查询全部的评论贴。
     *                  当有拼接user_id时，就会查询用户自己发布的帖子
     * @param offset    每页起始行的行号
     * @param limit     每页显示的记录数
     * @return
     */
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    //如果方法只有一个参数，且这个参数将用于拼接动态sql（即在<if>里使用）
    // 那么这个参数必须起别名（@Param("xxx")）
    /**
     * 查询记录数，方便分页
     * @param userId
     * @return
     */
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int discussPostId,int commentCount);

}
