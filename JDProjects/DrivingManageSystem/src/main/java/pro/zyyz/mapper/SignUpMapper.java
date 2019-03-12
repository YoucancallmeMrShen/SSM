package pro.zyyz.mapper;

import org.apache.ibatis.annotations.Param;
import pro.zyyz.pojo.AreaPojo;
import pro.zyyz.pojo.CityPojo;
import pro.zyyz.pojo.ProvincePojo;
import pro.zyyz.pojo.StudentBasePojo;

import java.util.List;

public interface SignUpMapper {
    /**
     * 获取数据库中的所有省级地址
     * @return
     */
    List<ProvincePojo> queryAllProvince();
    /**
     * 获取数据库中的所有市级地址
     * @return
     */
    List<AreaPojo> queryAreaByAddressCityCode(String addressCityCode);
    /**
     * 获取数据库中的所有县级地址
     * @return
     */
    List<CityPojo> queryCityByAddressProvinceCode(String addressProvinceCode);

    /**
     * 添加学员信息
     * @param studentBasePojo
     */
    void insertStudentBase(StudentBasePojo studentBasePojo);

    /**
     * 通过keywords关键字获取相应学员基本信息
     * @param keywords
     * @return
     */
    List<StudentBasePojo> queryStudentBaseByKeywords(@Param("type") String type,@Param("keywords") String keywords);
}
