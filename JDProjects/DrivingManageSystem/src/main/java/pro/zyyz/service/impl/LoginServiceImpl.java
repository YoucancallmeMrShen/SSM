package pro.zyyz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.zyyz.mapper.LoginMapper;
import pro.zyyz.pojo.UserBasePojo;
import pro.zyyz.service.LoginService;
import pro.zyyz.util.Code;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserBasePojo loginUserService(UserBasePojo userBasePojo) {
        UserBasePojo returnUserBase = loginMapper.queryByUsernameAndPassword(userBasePojo);
        if(returnUserBase != null){
            if(returnUserBase.getPassword().equals(userBasePojo.getPassword())){
                returnUserBase.setMessage(Code.SUCCESS);
                return returnUserBase;
            }else {
                returnUserBase.setMessage(Code.ERROR);
                return returnUserBase;
            }
        }else{
            UserBasePojo userBasePojo1 = new UserBasePojo();
            userBasePojo1.setMessage(Code.ERROR_NULL);
            return userBasePojo1;
        }

    }
}
