package com.zeqinlin.MyCommunity.controller;

import com.zeqinlin.MyCommunity.entity.Comment;
import com.zeqinlin.MyCommunity.service.CommentService;
import com.zeqinlin.MyCommunity.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Description:添加评论
 * date: 2021/5/26 15:32
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private HostHolder hostHolder;

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/add/{discussPostId}",method = RequestMethod.POST)
    public String addComment(@PathVariable("discussPostId") int discussPostId, Comment comment){

        comment.setUserId(hostHolder.getUser().getId());
        comment.setStatus(0);
        comment.setCreateTime(new Date());

        commentService.addComment(comment);

        return "redirect:/discuss/detail/" + discussPostId;


    }
}
