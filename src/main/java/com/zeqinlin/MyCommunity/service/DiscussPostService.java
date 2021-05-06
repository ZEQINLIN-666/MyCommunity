package com.zeqinlin.MyCommunity.service;

import com.zeqinlin.MyCommunity.dao.DiscussPostMapper;
import com.zeqinlin.MyCommunity.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:用于调用DiscussPostMapper查询数据并将结果返回给controller层。
 *              从而提供查询所有帖子、查询我的帖子的服务。
 * date: 2021/5/4 16:10
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findSelectDiscussPost(int userId,int offset,int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
