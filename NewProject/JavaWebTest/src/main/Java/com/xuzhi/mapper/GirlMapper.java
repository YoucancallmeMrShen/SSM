package com.xuzhi.mapper;

import com.xuzhi.model.Girl;

public interface GirlMapper {
    int insert(Girl girl);
    Girl queryById(Long id);
}
