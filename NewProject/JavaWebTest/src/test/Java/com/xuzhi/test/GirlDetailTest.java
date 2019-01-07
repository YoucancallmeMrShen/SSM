package com.xuzhi.test;

import com.xuzhi.mapper.GirlDetailMapper;
import com.xuzhi.model.GirlDetail;
import com.xuzhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class GirlDetailTest {
    @Test
    public void Test1(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlDetailMapper mapper = sqlSession.getMapper(GirlDetailMapper.class);
        GirlDetail girlDetail=mapper.queryById(1);
        System.out.println(girlDetail);


        sqlSession.close();
    }

    @Test
    public void Test2(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlDetailMapper mapper = sqlSession.getMapper(GirlDetailMapper.class);
        GirlDetail girlDetail=mapper.queryByIdByStep(1);
        System.out.println(girlDetail);
        sqlSession.close();
    }
}
