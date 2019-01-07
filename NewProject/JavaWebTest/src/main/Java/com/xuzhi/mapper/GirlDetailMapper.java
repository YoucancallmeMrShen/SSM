package com.xuzhi.mapper;

import com.xuzhi.model.GirlBlog;
import com.xuzhi.model.GirlDetail;
import com.xuzhi.model.GirlWithDetail;
import org.apache.ibatis.annotations.Param;

public interface GirlDetailMapper {
    GirlDetail queryById(@Param("id") Integer id);
    GirlDetail queryByIdByStep(@Param("id") Integer id);


}
