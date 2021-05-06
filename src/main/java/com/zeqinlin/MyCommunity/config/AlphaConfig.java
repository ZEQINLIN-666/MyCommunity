package com.zeqinlin.MyCommunity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * Description:
 * date: 2021/5/3 16:21
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Configuration
public class AlphaConfig {

    @Bean   //该方法返回的对象将被装配到容器中
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
