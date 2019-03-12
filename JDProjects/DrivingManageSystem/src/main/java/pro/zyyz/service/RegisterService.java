package pro.zyyz.service;

import pro.zyyz.pojo.UserBasePojo;

public interface RegisterService {
    /**
     * 注册时的用户基本信息
     * @param userBasePojo
     * @return
     */
    int insertBaseUser(UserBasePojo userBasePojo);
}
