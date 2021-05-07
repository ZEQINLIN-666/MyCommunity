package com.zeqinlin.MyCommunity.util;

/**
 * Description:封装一些激活状态的常量
 * date: 2021/5/7 17:08
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
public interface CommunityConstant {
    //激活成功
    int ACTIVATION_SUCCESS = 0;

    //重复激活
    int ACTIVATION_REPEAT = 1;

    //激活失败
    int ACTIVATION_FAILURE = 2;
}
