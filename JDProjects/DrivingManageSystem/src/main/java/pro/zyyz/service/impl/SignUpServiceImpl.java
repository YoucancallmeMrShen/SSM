package pro.zyyz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<StudentBasePojo> getStudentBaseByKeywords(String type, String keywords, PageInfo<StudentBasePojo> pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<StudentBasePojo> queryStudentBaseList = signUpMapper.queryStudentBaseByKeywords(type, keywords);
        pageInfo = new PageInfo<>(queryStudentBaseList);
        return pageInfo;
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
