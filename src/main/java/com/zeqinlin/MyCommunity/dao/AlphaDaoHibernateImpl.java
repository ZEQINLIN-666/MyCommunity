package com.zeqinlin.MyCommunity.dao;

import org.springframework.stereotype.Repository;

/**
 * Description:
 * date: 2021/5/3 15:59
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Repository("hibernate")    //括号里起别名
public class AlphaDaoHibernateImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
