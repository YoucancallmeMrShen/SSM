package pro.zyyz.mapper;

import pro.zyyz.pojo.UserBasePojo;

public interface LoginMapper {
    UserBasePojo queryByUsernameAndPassword(UserBasePojo userBasePojo);
}
