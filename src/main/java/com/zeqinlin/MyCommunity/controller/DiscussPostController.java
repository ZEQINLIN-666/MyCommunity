package com.zeqinlin.MyCommunity.controller;

import com.zeqinlin.MyCommunity.entity.Comment;
import com.zeqinlin.MyCommunity.entity.DiscussPost;
import com.zeqinlin.MyCommunity.entity.Page;
import com.zeqinlin.MyCommunity.entity.User;
import com.zeqinlin.MyCommunity.service.CommentService;
import com.zeqinlin.MyCommunity.service.DiscussPostService;
import com.zeqinlin.MyCommunity.service.UserService;
import com.zeqinlin.MyCommunity.util.CommunityConstant;
import com.zeqinlin.MyCommunity.util.CommunityUtil;
import com.zeqinlin.MyCommunity.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

/**
 * Description:
 * date: 2021/5/20 15:17
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@RequestMapping("/discuss")
@Controller
public class DiscussPostController  implements CommunityConstant {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addDiscussPost(String title, String content) {
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtil.getJSONString(403, "你还没有登录！");
        }
        DiscussPost post = new DiscussPost();
        post.setUserId(user.getId());
        post.setTitle(title);
        post.setContent(content);
        post.setCreateTime(new Date());
        discussPostService.addDiscussPost(post);

        //发布错误的异常不在此处处理
        return CommunityUtil.getJSONString(0, "发布成功");
    }

    @RequestMapping(path = "/detail/{discussPostId}", method = RequestMethod.GET)
    public String getDiscussPost(@PathVariable("discussPostId") int discussPostId, Model model, Page page) {
        //帖子加入模板
        DiscussPost post = discussPostService.findDiscussPostById(discussPostId);
        model.addAttribute("post", post);
        //用户信息加入模板
        User user = userService.findUserById(post.getUserId());
        model.addAttribute("user", user);

        page.setLimit(5);
        page.setPath("/discuss/detail/" + discussPostId);
        page.setRows(post.getCommentCount());

        /*
        * 评论（comment）：给帖子的评论
        * 回复（reply）：给评论的评论
        *
        * */
        //评论列表
        List<Comment> commentList = commentService.findCommentByEntity(
                ENTITY_TYPE_POST, post.getId(), page.getOffset(), page.getLimit());
        //评论显示对象列表
        List<Map<String,Object>> commentViewObjectList = new ArrayList<>();

        if(commentList != null){
            for(Comment comment:commentList){
                //每个评论的显示对象
                Map<String,Object> commentViewObject = new HashMap<>();
                //往显示对象中添加评论的内容
                commentViewObject.put("comment",comment);
                //往显示对象中添加评论的作者
                commentViewObject.put("user",userService.findUserById(comment.getUserId()));

                //每次评论都会有回复，下面要遍历插入回复，回复不进行分页
                //回复列表
                List<Comment> replyList = commentService.findCommentByEntity(
                        ENTITY_TYPE_COMMENT, comment.getId(), 0, Integer.MAX_VALUE);

                //回复的显示对象列表
                List<Map<String,Object>> replyViewObjectList = new ArrayList<>();

                if(replyList != null){
                    for(Comment reply:replyList){
                        Map<String,Object> replyViewObject = new HashMap<>();
                        //回复
                        replyViewObject.put("reply",reply);
                        //回复的作者
                        replyViewObject.put("user",userService.findUserById(reply.getUserId()));
                        //回复的目标
                        User target = reply.getTargetId() == 0 ? null : userService.findUserById(reply.getTargetId());
                        replyViewObject.put("target",target);
                        replyViewObjectList.add(replyViewObject);

                    }
                }
                commentViewObject.put("replys",replyViewObjectList);

                //回复数量
                int replyCount = commentService.findCountByEntity(ENTITY_TYPE_COMMENT,comment.getId());
                commentViewObject.put("replyCount",replyCount);


                commentViewObjectList.add(commentViewObject);
            }
        }
        model.addAttribute("comments",commentViewObjectList);
        return "/site/discuss-detail";

    }
}
