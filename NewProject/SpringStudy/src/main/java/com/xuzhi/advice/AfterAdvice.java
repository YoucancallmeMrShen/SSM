package com.xuzhi.advice;

public class AfterAdvice {
    public void methodAfter(){
        System.out.println("在执行方法之后执行。。。。。。。");
    }
    public void methodAfter(String name,int num){
        System.out.println(name+num);
    }
}
