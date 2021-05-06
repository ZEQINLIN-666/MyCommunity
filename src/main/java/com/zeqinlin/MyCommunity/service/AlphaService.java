package com.zeqinlin.MyCommunity.service;

import com.zeqinlin.MyCommunity.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
}
