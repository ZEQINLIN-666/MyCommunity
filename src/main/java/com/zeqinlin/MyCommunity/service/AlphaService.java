package com.zeqinlin.MyCommunity.service;

import com.zeqinlin.MyCommunity.dao.AlphaDao;
import com.zeqinlin.MyCommunity.dao.DiscussPostMapper;
import com.zeqinlin.MyCommunity.dao.UserMapper;
import com.zeqinlin.MyCommunity.entity.User;
import com.zeqinlin.MyCommunity.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

/**
 * Description:
 * date: 2021/5/3 16:12
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Service
public class AlphaService {
    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化AlphaService");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("对象即将被销毁");
    }

    public String find(){
        return alphaDao.select();
    }

    /*事务的传播机制
        REQUIRED:支持当前事务（外部事务），如果不存在则创建新事务
        REQUIRED_NEW:创建一个新事务，并且暂停当前事务（外部事务）
        NESTED:如果当前存在事务（外部事务），则嵌套在该事务中执行（独立的提交和回滚）
    *
    * */
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public Object save1(){
        User user = new User();
        user.setUsername("lisi");
        user.setSalt(CommunityUtil.generateUUID().substring(0,5));
        user.setPassword(CommunityUtil.md5("123"+user.getSalt()));
        user.setHeaderUrl("http://image.newcoder.com/head/99t.png");
        user.setEmail("lisi@163.com");
        user.setCreateTime(new Date());

        userMapper.insertUser(user);

        int a = 3/0;
        return a;
    }
}
