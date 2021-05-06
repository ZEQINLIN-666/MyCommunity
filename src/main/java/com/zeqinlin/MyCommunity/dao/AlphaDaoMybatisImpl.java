package com.zeqinlin.MyCommunity.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * date: 2021/5/3 16:01
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Repository
@Primary    //优先注入这个bean
public class AlphaDaoMybatisImpl implements  AlphaDao {
    @Override
    public String select() {
        return "Mybatis";
    }
}
