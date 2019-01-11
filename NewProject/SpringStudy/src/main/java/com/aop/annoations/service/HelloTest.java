package com.aop.annoations.service;


import org.springframework.stereotype.Component;

@Component
public class HelloTest {
    public void helloTest(){
        System.out.println("这是我的测试执行方法");
    }
}
