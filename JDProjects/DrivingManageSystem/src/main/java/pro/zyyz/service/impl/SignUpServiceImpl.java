package pro.zyyz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.zyyz.mapper.SignUpMapper;
import pro.zyyz.pojo.AreaPojo;
import pro.zyyz.pojo.CityPojo;
import pro.zyyz.pojo.ProvincePojo;
import pro.zyyz.pojo.StudentBasePojo;
import pro.zyyz.service.SignUpService;

import java.util.List;

@Service("signUpService")
public class SignUpServiceImpl implements SignUpService {
    @Autowired
    private SignUpMapper signUpMapper;


    @Override
    public void addStudentBase(StudentBasePojo studentBasePojo) {
        signUpMapper.insertStudentBase(studentBasePojo);
    }

    @Override
    public List<StudentBasePojo> getStudentBaseByKeywords(String type, String keywords) {
        String sql = "studentName != ''";
        if(type.equals("all")){

        }else if (type.equals("name")){
            sql = "studentName like '%"+keywords+"%'";
        }else if (type.equals("nameId")){
            sql = "studentNameId like '%"+keywords+"%'";
        }else if (type.equals("type")){
            sql = "studentType like '%"+keywords+"%'";
        }else{
            sql = "studentSignDate like '%"+keywords+"%'";
        }
        return signUpMapper.queryStudentBaseByKeywords( sql );
    }

    @Override
    public List<ProvincePojo> queryAllProvince() {
        return signUpMapper.queryAllProvince();
    }

    @Override
    public List<AreaPojo> queryCityByAddressCityCode(String addressCityCode) {
        return signUpMapper.queryAreaByAddressCityCode(addressCityCode);
    }

    @Override
    public List<CityPojo> queryCityByAddressProvinceCode(String addressProvinceCode) {
        return signUpMapper.queryCityByAddressProvinceCode(addressProvinceCode);
    }
}
