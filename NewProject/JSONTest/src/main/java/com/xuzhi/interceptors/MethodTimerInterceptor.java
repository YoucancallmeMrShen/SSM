package com.xuzhi.interceptors;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 方法耗时统计的拦截器
 */
public class MethodTimerInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER=Logger.getLogger(MethodTimerInterceptor.class);


    //前置功能 开始到结束，计算两个点之间所需要的时间
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、定义开始时间
        long start=System.currentTimeMillis();
        //2、将开始时间存到请求域当中
        request.setAttribute("start",start);
        //记录请求日志
        LOGGER.info(request.getRequestURI()+"请求到达！");
        //返回true，才会去找下一个拦截器，如果没有下一个拦截器，则去到Controller执行请求
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //1、得到开始的时间
        long start= (long) request.getAttribute("start");
        //2、得到结束的时间
        long end=System.currentTimeMillis();
        //3、计算耗时
        long speedTime=end-start;
        if(speedTime>=1000){
            LOGGER.warn("请求耗时严重，耗时："+speedTime+"毫秒");
        }else{
            LOGGER.info("请求耗时正常，耗时："+speedTime+"毫秒");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
