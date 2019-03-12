package pro.zyyz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.zyyz.mapper.RegisterMapper;
import pro.zyyz.pojo.UserBasePojo;
import pro.zyyz.service.RegisterService;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;


    @Override
    public int insertBaseUser(UserBasePojo userBasePojo) {

        return registerMapper.insertUserBase(userBasePojo);
    }
}
