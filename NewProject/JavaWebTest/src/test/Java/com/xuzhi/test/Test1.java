package com.xuzhi.test;

import com.xuzhi.mapper.GirlMapper;
import com.xuzhi.mapper.GirlMapperSQL;
import com.xuzhi.model.Girl;
import com.xuzhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void test3(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper girlMapper=sqlSession.getMapper(GirlMapper.class);

        Girl girl=girlMapper.queryByNameFlower("wangxuzhi","nihao123");
        System.out.println(girl.getBirthday());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper girlMapper=sqlSession.getMapper(GirlMapper.class);

        Girl girl=girlMapper.queryByNameFlower1(new Girl("wangxuzhi","nihao123"));
        System.out.println(girl.getBirthday());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper girlMapper=sqlSession.getMapper(GirlMapper.class);
        Map<String,Object> map=new HashMap<>();
        map.put("name","wangxuzhi");
        map.put("flower","nihao123");

        Girl girl=girlMapper.queryByNameFlower2(map);
        System.out.println(girl.getBirthday());

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test6(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapper girlMapper=sqlSession.getMapper(GirlMapper.class);
        ArrayList<Girl> array =girlMapper.queryByNameFlower3("wangxuzhi",null);
        System.out.println(array);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test7(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlMapperSQL girlMapper=sqlSession.getMapper(GirlMapperSQL.class);
        ArrayList<Girl> array =girlMapper.queryByNameFlower("wangxuzhi","nihao");
        System.out.println(array);

        sqlSession.commit();
        sqlSession.close();
    }
}
