package com.xuzhi.advice;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class BeforeAdvice {
    public void methodBefore(){
        System.out.println("切面之前完成。。。。。。。。。。。。。。。。。。。。。。。。。");
    }

    //JoinPoint可以获取几乎所有的这个方法的信息
    //作用，可以打印输出日志文件
    public void before(JoinPoint joinPoint){
        //获取方法的方法名
        String name=joinPoint.getSignature().getName();
        System.out.println("method:"+name);
        //获取方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
    }
}
