package pro.zyyz.service;

import pro.zyyz.pojo.UserBasePojo;

public interface LoginService {

    /**
     * 登录
     * 如果账号密码匹配，即登录成功，则返回JSONObject
     * 如果不匹配则返回Code.ERROR
     * @param userBasePojo
     * @return
     */
    UserBasePojo loginUserService(UserBasePojo userBasePojo);
}
