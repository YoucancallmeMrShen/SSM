package com.xuzhi.spring;

import com.xuzhi.pojo.Girl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredTest {
    @Test
    public void test1() {
        // 1、获取上下文对象，spring里面声明对象都需要通过上下文来获取
        ApplicationContext ctx = new ClassPathXmlApplicationContext("autowired.xml");
        Girl girl=ctx.getBean("girl" ,Girl.class);
        girl.getPay().pay();

    }
}
