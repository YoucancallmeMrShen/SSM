package com.xuzhi.advice;

public class AfterReturningAdvice {

    public void afterReturning(String returning){
        System.out.println("在返回值之后执行，程序完成前执行");
        System.out.println("返回值："+returning);
    }
    public void after(){
        System.out.println("在程序完成后执行");
    }
}
