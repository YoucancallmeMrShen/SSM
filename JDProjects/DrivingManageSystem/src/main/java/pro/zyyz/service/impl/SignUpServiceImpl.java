package pro.zyyz.service.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
    public String getStudentBaseByKeywords(String type, String keywords) {
        List<StudentBasePojo> studentBasePojoList = signUpMapper.queryStudentBaseByKeywords(type, keywords);
        JSONArray getStudentBases = new JSONArray();
        for(int i = 0 ; i < studentBasePojoList.size(); i++){
            JSONObject jsonObject = new JSONObject();
            StudentBasePojo studentBasePojo = studentBasePojoList.get(i);
            jsonObject.put("studentId" , studentBasePojo.getStudentId());
            jsonObject.put("studentName" , studentBasePojo.getStudentName());
            jsonObject.put("studentNameId" , studentBasePojo.getStudentNameId());
            jsonObject.put("studentPhone" , studentBasePojo.getStudentPhone());
            jsonObject.put("studentReference" , studentBasePojo.getStudentReference());
            jsonObject.put("studentType" , studentBasePojo.getStudentType());
            jsonObject.put("studentSignDate" , studentBasePojo.getStudentSignDate());
            jsonObject.put("studentZip" , studentBasePojo.getStudentZip());
            jsonObject.put("studentAddressProvince" , studentBasePojo.getStudentProvince().getName());
            jsonObject.put("studentAddressCity" , studentBasePojo.getStudentCity().getName());
            jsonObject.put("studentAddressArea" , studentBasePojo.getStudentArea().getName());
            jsonObject.put("studentAddressSupp" , studentBasePojo.getStudentAddressSupp());
            getStudentBases.add(jsonObject);
        }
        return "{\"code\":200,\"msg\":\"\",\"count\":"+studentBasePojoList.size()+",\"data\":"+getStudentBases.toString()+"}";
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
