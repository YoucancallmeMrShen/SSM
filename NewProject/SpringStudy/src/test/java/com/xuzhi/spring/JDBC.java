package com.xuzhi.spring;

import com.xuzhi.pojo.DaoTest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBC {
    @Test
    public void test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        DaoTest daoTest=ctx.getBean("jdbc",DaoTest.class);
        System.out.println(daoTest);
    }
}
