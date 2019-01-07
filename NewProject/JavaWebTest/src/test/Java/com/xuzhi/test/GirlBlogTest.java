package com.xuzhi.test;

import com.xuzhi.mapper.GirlWithBlogMapper;
import com.xuzhi.model.GirlBlog;
import com.xuzhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class GirlBlogTest {
    @Test
    public void test1(){
        SqlSession sqlSession= MybatisUtil.getSession();
        GirlWithBlogMapper mapper = sqlSession.getMapper(GirlWithBlogMapper.class);
        GirlBlog girlBlog = mapper.queryByIdWithBlog(1);
        System.out.println(girlBlog);
        sqlSession.close();
    }
}
