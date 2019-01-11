package com.xuzhi.aop;

import com.xuzhi.service.AfterReturnningService;
import com.xuzhi.service.ProviderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    @Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("aopContext.xml");
        //如果不是spring容器所管理的bean，那么织入的行为无法生效（因为ProviderService对象是new出来的）
        //ProviderService providerService=new ProviderService();
        ProviderService providerService = ctx.getBean("providerService", ProviderService.class);
        providerService.add("admin",123);
    }
    @Test
    public void test1(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("aopContext.xml");
        AfterReturnningService afterReturnningService = ctx.getBean("afterReturnningService", AfterReturnningService.class);
        afterReturnningService.afterReturnService();
    }
}
