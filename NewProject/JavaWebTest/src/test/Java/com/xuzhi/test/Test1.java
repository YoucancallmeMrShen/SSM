package com.xuzhi.test;

import com.xuzhi.mapper.GirlMapper;
import com.xuzhi.model.Girl;
import com.xuzhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

public class Test1 {
    @Test
    public void test1(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper girlMapper=sqlSession.getMapper(GirlMapper.class);
        Girl girl=new Girl();
        girl.setName("wangxuzhi");
        girl.setFlower("nihao");
        girl.setBirthday(new Date());

        girlMapper.insert(girl);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper girlMapper=sqlSession.getMapper(GirlMapper.class);

        Girl girl=girlMapper.queryById(1L);
        System.out.println(girl.getName());

        sqlSession.commit();
        sqlSession.close();
    }
}
