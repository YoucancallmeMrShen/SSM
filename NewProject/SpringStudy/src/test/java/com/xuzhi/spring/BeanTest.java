package com.xuzhi.spring;

import com.xuzhi.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BeanTest {
    @Test
    public void test3() {
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beanTest.xml");
        People people=ctx.getBean("people",People.class);
//        System.out.println(Arrays.toString(people.getFriends()));
        System.out.println(people.getFriends().length);
        System.out.println(people.getNumbers().size());
        System.out.println(people.getGirls().get(1).getName());
        System.out.println(people);
    }
}
