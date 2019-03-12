package pro.zyyz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.zyyz.pojo.AreaPojo;
import pro.zyyz.pojo.CityPojo;
import pro.zyyz.pojo.StudentBasePojo;
import pro.zyyz.service.SignUpService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sign")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    /**
     * 添加学员信息初始化添加学员信息Controller
     * @param model
     * @return
     */
    @RequestMapping("/addStudentInit")
    public String addStudent(Model model, HttpSession session){
        boolean loginStatus = (boolean) session.getAttribute("loginStatus");
        if(loginStatus){
            model.addAttribute("addStudentProvince",signUpService.queryAllProvince());
            return "addStudent";
        }else{
            model.addAttribute("loginMessage", "请先登录账号，再进行操作");
            return "login";
        }
    }

    /**
     * 添加学员基本信息（录入）
     * @param studentBasePojo
     * @return
     */
    @RequestMapping("/addStudentBase")
    @ResponseBody
    public String addStudentBase(StudentBasePojo studentBasePojo,HttpSession session){
        String userId = (String) session.getAttribute("loginUserId");
        studentBasePojo.setUserId(userId);
        signUpService.addStudentBase(studentBasePojo);
        return "redirect:/sign/addStudentInit";
    }

    /**
     * 获取自己添加的学员的信息
     * @param keywords
     * @return
     */
    @RequestMapping("/getStudentBase")
    @ResponseBody
    public String getStudentBase(@RequestParam("type") String type, @RequestParam("keywords") String keywords){
        return signUpService.getStudentBaseByKeywords(type, keywords);

    }

    /**
     * 通过addressProviceCode（省级代码）获得该省的市级信息
     * @param addressProvinceCode
     * @return
     */
    @RequestMapping("/getAddress/addressCity/{addressProvinceCode}")
    @ResponseBody
    public List<CityPojo> getAddressCities(@PathVariable("addressProvinceCode") String addressProvinceCode){
        return signUpService.queryCityByAddressProvinceCode(addressProvinceCode);
    }

    /**
     * 通过addressCityCode（市级代码）获得该市的县级信息
     * @param addressCityCode
     * @return
     */
    @RequestMapping("/getAddress/addressArea/{addressCityCode}")
    @ResponseBody
    public List<AreaPojo> getAddressAreas(@PathVariable("addressCityCode") String addressCityCode){
        return signUpService.queryCityByAddressCityCode(addressCityCode);
    }


}
