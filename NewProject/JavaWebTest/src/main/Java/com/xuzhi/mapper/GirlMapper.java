package com.xuzhi.mapper;

import com.xuzhi.model.Girl;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Map;

public interface GirlMapper {
    int insert(Girl girl);
    Girl queryById(Long id);

    /**
     * 通过name和flower进行复合查询，通过注解可以在mapper的配置文件中直接使用#{name}和#{flower}来接收参数
     * 否则必须使用mybatis默认的参数接收方式，param1，param2或者arg0,arg1
     * 推荐使用注解的方式来进行传递参数
     * @param name
     * @param flower
     * @return
     */
    Girl queryByNameFlower(@Param("name") String name,@Param("flower") String flower);

    /**
     * 通过javabean来传递参数
     * mapper.xml中调用参数时只需要使用实体类中的属性名即可
     * @param girl
     * @return
     */
    Girl queryByNameFlower1(Girl girl);

    /**
     * 通过hashmap传参
     * @return
     */
    Girl queryByNameFlower2(Map<String,Object> map);

    ArrayList<Girl> queryByNameFlower3(@Param("name") String name,@Param("flower") String flower);



}
