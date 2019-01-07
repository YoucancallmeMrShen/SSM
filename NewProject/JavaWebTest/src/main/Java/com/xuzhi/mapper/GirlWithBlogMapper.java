package com.xuzhi.mapper;

import com.xuzhi.model.GirlBlog;
import org.apache.ibatis.annotations.Param;

public interface GirlWithBlogMapper {
    /**
     * 通过id查询某个用户的所有信息和该用户的所有博客内容
     * @param id
     * @return
     */
    GirlBlog queryByIdWithBlog(@Param("id") Integer id);
}
