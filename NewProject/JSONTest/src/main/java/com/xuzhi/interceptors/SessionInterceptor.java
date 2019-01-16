package com.xuzhi.interceptors;

import com.xuzhi.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 会话拦截器
 */
public class SessionInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER=Logger.getLogger(SessionInterceptor.class);

    //检查当前会话是不是有该User，如果有，放行，如果没有，则拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取会话中的User对象
        Object user=request.getSession().getAttribute("SESSION_USER");

        //判断该用户是否登录，
        if(user == null){
            LOGGER.warn("您不具备该权限，请先登录");
            return false;
        }

        //先判断user是否为空，即判断用户是不是登录
        //如果用户登录，则判断用户是不是User类型
        if(user instanceof User){
            //去数据库检测该用户是否存在,给予该用户冻结状态，密码附空
            User u= (User) user;
            u.setPassword(null);
            request.getSession().setAttribute("SESSION_USER",u);
            LOGGER.info(u.getName()+"登录状态");
            return true;
        }else{
            LOGGER.warn("请先登录，不要搞事情");
            return false;
        }
    }
}
