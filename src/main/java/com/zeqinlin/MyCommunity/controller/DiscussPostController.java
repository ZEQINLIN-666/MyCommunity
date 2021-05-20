package com.zeqinlin.MyCommunity.controller;

import com.zeqinlin.MyCommunity.entity.DiscussPost;
import com.zeqinlin.MyCommunity.entity.User;
import com.zeqinlin.MyCommunity.service.DiscussPostService;
import com.zeqinlin.MyCommunity.service.UserService;
import com.zeqinlin.MyCommunity.util.CommunityUtil;
import com.zeqinlin.MyCommunity.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;

/**
 * Description:
 * date: 2021/5/20 15:17
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@RequestMapping("/discuss")
@Controller
public class DiscussPostController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    @ResponseBody
    public String addDiscussPost(String title,String content){
        User user = hostHolder.getUser();
        if(user == null){
            return CommunityUtil.getJSONString(403,"你还没有登录！");
        }
        DiscussPost post = new DiscussPost();
        post.setUserId(user.getId());
        post.setTitle(title);
        post.setContent(content);
        post.setCreateTime(new Date());
        discussPostService.addDiscussPost(post);

        //发布错误的异常不在此处处理
        return CommunityUtil.getJSONString(0,"发布成功");
    }

    @RequestMapping(path = "/detail/{discussPostId}",method = RequestMethod.GET)
    public String getDiscussPost(@PathVariable("discussPostId") int discussPostId, Model model){
        //帖子加入模板
        DiscussPost post = discussPostService.findDiscussPostById(discussPostId);
        model.addAttribute("post",post);
        //用户信息加入模板
        User user = userService.findUserById(post.getUserId());
        model.addAttribute("user",user);
        return "/site/discuss-detail";

    }
}
