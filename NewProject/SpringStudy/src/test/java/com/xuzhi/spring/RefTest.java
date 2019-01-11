package com.xuzhi.spring;

import com.xuzhi.pojo.Car;
import com.xuzhi.pojo.Girl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RefTest {
    @Test
    public void test1(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx=new ClassPathXmlApplicationContext("refContext.xml");
        Girl girl=ctx.getBean("girl",Girl.class);
        Girl girl1=ctx.getBean(Girl.class);
        girl1.getPay().pay();
    }

    @Test
    public void test2(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx=new ClassPathXmlApplicationContext("refContext.xml");
        Girl girl1=ctx.getBean("girl1",Girl.class);
        System.out.println(girl1.getName());
    }

    @Test
    public void test3(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx=new ClassPathXmlApplicationContext("refContext.xml");
        Car car=ctx.getBean("car",Car.class);
        System.out.println(car);
    }
}
