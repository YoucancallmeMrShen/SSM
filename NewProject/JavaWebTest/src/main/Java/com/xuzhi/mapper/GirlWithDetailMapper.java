package com.xuzhi.mapper;

import com.xuzhi.model.GirlWithDetail;
import org.apache.ibatis.annotations.Param;

public interface GirlWithDetailMapper {
    GirlWithDetail queryById(@Param("id") Integer id);
}
