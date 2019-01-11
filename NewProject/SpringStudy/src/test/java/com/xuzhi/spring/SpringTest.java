package com.xuzhi.spring;

import com.xuzhi.pojo.Girl;
import com.xuzhi.pojo.PeteryGirl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    public void test1(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2、通过这个对象来获取girl
        Girl girl= (Girl) ctx.getBean("girl");
        System.out.println(girl);

    }

    @Test
    public void test2(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2、通过这个对象来获取girl
        Pay pay= ctx.getBean("pay",Pay.class);
        pay.pay();
    }

    @Test
    public void test3(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2、通过这个对象来获取girl
        Girl peteryGirl= ctx.getBean("peteryGirl", Girl.class);
        System.out.println(peteryGirl);
    }

    @Test
    public void test4(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2、通过这个对象来获取girl
        Girl peteryGirl= ctx.getBean("peteryGirl", Girl.class);
        System.out.println(peteryGirl);
        ((ClassPathXmlApplicationContext) ctx).close();
//        ((ClassPathXmlApplicationContext) ctx).refresh();
//        ((ClassPathXmlApplicationContext) ctx).destroy();
    }

    @Test
    public void test5(){
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        // 2、通过这个对象来获取girl
        Girl peteryGirl= ctx.getBean("peteryGirl", Girl.class);
        System.out.println(peteryGirl);
    }

}
