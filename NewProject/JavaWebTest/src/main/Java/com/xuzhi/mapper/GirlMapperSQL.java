package com.xuzhi.mapper;

import com.xuzhi.model.Girl;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface GirlMapperSQL {
    ArrayList<Girl> queryByNameFlower(@Param("name") String name,@Param("flower") String flower);
}
