package com.zeqinlin.MyCommunity.interceptor;

import com.zeqinlin.MyCommunity.entity.LoginTicket;
import com.zeqinlin.MyCommunity.entity.User;
import com.zeqinlin.MyCommunity.service.UserService;
import com.zeqinlin.MyCommunity.util.CookieUtil;
import com.zeqinlin.MyCommunity.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Description:
 * date: 2021/5/14 17:12
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */
@Component
public class LoginTicketInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @Override
    //controller请求执行前，获取线程中的用户信息，保存在hostHolder中
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从cookie中获取凭证
        String ticket = CookieUtil.getValue(request, "ticket");

        if (ticket != null) {
            //查询凭证
            LoginTicket loginTicket = userService.findLoginTicket(ticket);
            //检查凭证是否有效
            if (loginTicket != null && loginTicket.getStatus() == 0 && loginTicket.getExpired().after(new Date())) {
                //根据凭证查询用户
                User user = userService.findUserById(loginTicket.getUserId());
                //在本次请求中持有用户
                //hostHolder利用ThreadLocal进行线程隔离
                hostHolder.setUser(user);
            }
        }

        return true;
    }

    //在controller请求之后，在模板之前，即在访问模板引擎时，已经持有了用户的数据，即index.html中有用户数据
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        User user = hostHolder.getUser();
        if (user != null && modelAndView != null) {
            modelAndView.addObject("loginUser",user);
        }
    }

    //在整个请求结束后，清理掉数据

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
