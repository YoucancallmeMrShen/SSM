package com.xuzhi.spring;

import com.xuzhi.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnocation {
    @Test
    public void test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService=ctx.getBean("userService",UserService.class);
        userService.eat();
    }
}
