package com.zyyz.annotations;

import com.aop.Test1;
import com.aop.annoations.service.HelloTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    @Test
    public void m1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("annotationsContext.xml");
        HelloTest helloTest = ctx.getBean("helloTest", HelloTest.class);
        Test1 test1 = ctx.getBean("test1", Test1.class);
        helloTest.helloTest();
        test1.test();
    }
}
