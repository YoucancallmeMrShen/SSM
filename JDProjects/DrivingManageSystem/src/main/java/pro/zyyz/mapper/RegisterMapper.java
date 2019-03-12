package pro.zyyz.mapper;

import pro.zyyz.pojo.UserBasePojo;

public interface RegisterMapper {
    /**
     * 插入基本数据
     * @param userBasePojo
     * @return
     */
    int insertUserBase(UserBasePojo userBasePojo);

}
