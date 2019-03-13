package pro.zyyz.service;

import com.github.pagehelper.PageInfo;
import pro.zyyz.pojo.AreaPojo;
import pro.zyyz.pojo.CityPojo;
import pro.zyyz.pojo.ProvincePojo;
import pro.zyyz.pojo.StudentBasePojo;

import java.util.List;

public interface SignUpService {

    /**
     * 添加学员信息
     * @param studentBasePojo
     */
    void addStudentBase(StudentBasePojo studentBasePojo);


    /**
     * 通过keywords（查询关键字）来查询学员的基本信息
     * @param type
     * @param keywords
     * @return
     */
    PageInfo<StudentBasePojo> getStudentBaseByKeywords(String type, String keywords, PageInfo<StudentBasePojo> pageInfo);

    /**
     * 获取数据库中的所有省级地址
     * @return
     */
    List<ProvincePojo> queryAllProvince();

    /**
     * 通过市级地址code代码获得该省级下的所有县级地址
     * @param addressCityCode
     * @return
     */
    List<AreaPojo> queryCityByAddressCityCode(String addressCityCode);

    /**
     * 通过省级地址code代码获得该省级下的所有市级地址
     * @param addressProvinceCode
     * @return
     */
    List<CityPojo> queryCityByAddressProvinceCode(String addressProvinceCode);
}
