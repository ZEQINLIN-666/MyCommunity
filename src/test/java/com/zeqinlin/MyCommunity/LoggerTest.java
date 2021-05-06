package com.zeqinlin.MyCommunity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description:
 * date: 2021/5/6 15:21
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes =MyCommunityApplication.class)
public class LoggerTest {
    private static  final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void testLog(){
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
        logger.warn("warn");
    }
}
