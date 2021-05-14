package com.zeqinlin.MyCommunity;

import com.zeqinlin.MyCommunity.dao.DiscussPostMapper;
import com.zeqinlin.MyCommunity.dao.LoginTicketMapper;
import com.zeqinlin.MyCommunity.dao.UserMapper;
import com.zeqinlin.MyCommunity.entity.DiscussPost;
import com.zeqinlin.MyCommunity.entity.LoginTicket;
import com.zeqinlin.MyCommunity.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * date: 2021/5/3 22:40
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =MyCommunityApplication.class)	//启用这个类作为配置类
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("test");
        user.setPassword("test666");
        user.setEmail("123@163.com");
        user.setSalt("abc");
        user.setHeaderUrl("http://www.newcoder.com/101.png");
        user.setCreateTime(new Date());
        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());

    }
    @Test
    public void testUpdate(){
        int rows = userMapper.updatePassword(150, "newpassword");
        System.out.println(rows);

        rows = userMapper.updateHeader(150,"http://www.newcode.com/200.png");
        System.out.println(rows);

        rows = userMapper.updateStatus(150,1);
        System.out.println(rows);

    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(1);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000*60*10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc",0);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

    }

}
