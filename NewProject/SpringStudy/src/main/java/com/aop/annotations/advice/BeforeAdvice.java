package com.aop.annotations.advice;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  //标记其为一个切面
@Component //标记当前这个类为spring的一个组件，相当于在xml中注册了一个bean
public class BeforeAdvice {

    //在com.aop包下的所有子包中的所有类的所有方法都可以切到（不包括本包，即不包括com.aop下的类）
    //@Before("execution(* com.aop.*.*.*(..))")
    //扫描com.aop本包及所有子包的所有类的所有方法(包括本包，既包括com.aop下的类)
    @Before("execution(* com.aop..*.*(..))")
    public void before(){
        System.out.println("在主方法之前运行");
    }
}
