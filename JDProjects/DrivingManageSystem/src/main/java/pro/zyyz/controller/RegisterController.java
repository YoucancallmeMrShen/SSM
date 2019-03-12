package pro.zyyz.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.zyyz.pojo.UserBasePojo;
import pro.zyyz.service.RegisterService;
import pro.zyyz.util.Code;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/user")
    public String register(UserBasePojo userBasePojo, Model model){
        userBasePojo.setUserType(Code.MANAGE_Three);
        int result = registerService.insertBaseUser(userBasePojo);
        if(result == 1){
            return "login";
        }else{
            model.addAttribute("registerMessage","注册失败，服务发生异常，请稍后重试！");
            return "register";
        }
    }
}