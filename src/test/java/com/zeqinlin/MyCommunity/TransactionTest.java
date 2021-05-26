package com.zeqinlin.MyCommunity;

import com.zeqinlin.MyCommunity.service.AlphaService;
import com.zeqinlin.MyCommunity.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * date: 2021/5/23 21:11
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =MyCommunityApplication.class)
public class TransactionTest {

    @Autowired
    private AlphaService alphaService;
    @Test
    public void testSave1(){
        Object obj = alphaService.save1();
        System.out.println(obj);
    }
}
