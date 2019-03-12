package pro.zyyz.controller;


import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.zyyz.pojo.UserBasePojo;
import pro.zyyz.service.LoginService;
import pro.zyyz.util.Code;
import pro.zyyz.util.EnCodeUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private LoginService loginService;


    @RequestMapping("/init")
    public String indexInit(Model model, HttpServletRequest request, HttpSession session){
        Cookie[] cookies = request.getCookies();
        if(cookies.length > 0){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("drivingUser")){
                    UserBasePojo initUser = new UserBasePojo();
                    JSONObject jsonObject = JSONObject.fromObject(EnCodeUtil.Base64Decode(cookie.getValue()));
                    initUser.setUsername(jsonObject.getString("username"));
                    initUser.setPassword(jsonObject.getString("password"));
                    UserBasePojo loginResult = loginService.loginUserService(initUser);
                    if(loginResult.getMessage().equals(Code.SUCCESS)) {
                        session.setAttribute("loginUserId", loginResult.getUserId());
                        session.setAttribute("loginUsername", loginResult.getUsername());
                        session.setAttribute("loginUserType", loginResult.getUserType());
                        model.addAttribute("loginStatus", true);
                        session.setAttribute("loginStatus", true);
                        return "home";
                    }
                }
            }
        }
        model.addAttribute("loginStatus",false);
        return "home";
    }

}
