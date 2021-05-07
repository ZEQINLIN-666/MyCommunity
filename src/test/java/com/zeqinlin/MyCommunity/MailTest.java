package com.zeqinlin.MyCommunity;

import com.zeqinlin.MyCommunity.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Description:
 * date: 2021/5/6 17:02
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =MyCommunityApplication.class)
public class MailTest {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void testTextMail(){
        mailClient.sendMail("495378451@qq.com","TEST","hello!");
    }

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","zeqin");

        String content = templateEngine.process("/mail/demo", context);

        mailClient.sendMail("495378451@qq.com","html",content);
    }
}
