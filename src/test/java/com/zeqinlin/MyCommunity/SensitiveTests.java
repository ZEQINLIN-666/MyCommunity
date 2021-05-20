package com.zeqinlin.MyCommunity;

import com.zeqinlin.MyCommunity.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:测试敏感词过滤
 * date: 2021/5/19 17:25
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =MyCommunityApplication.class)
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter(){
        String text = "你是想赌博，嫖娼，吸毒，还是想在监狱过一辈子！";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
