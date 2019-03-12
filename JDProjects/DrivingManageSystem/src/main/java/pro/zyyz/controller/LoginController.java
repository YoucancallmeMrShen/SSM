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
import pro.zyyz.util.WebPathInitServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录操作
     * @param userBasePojo
     * @param model
     * @param response
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/user")
    public String loginUser(UserBasePojo userBasePojo , Model model, HttpServletResponse response, HttpServletRequest request , HttpSession session){
        UserBasePojo loginResult = loginService.loginUserService(userBasePojo);
            if(loginResult.getMessage().equals(Code.SUCCESS)){
                JSONObject loginUser = new JSONObject();
                loginUser.put("username",loginResult.getUsername());
                loginUser.put("password",loginResult.getPassword());
                System.out.println(userBasePojo.getRemberMe());
                if(userBasePojo.getRemberMe() != null){     //根据用户选择是否记住密码来判断是否增加cookie
                    addCookie(response,"drivingUser", loginUser.toString());
                }
                session.setAttribute("loginUserId", loginResult.getUserId());
                session.setAttribute("loginUsername", loginResult.getUsername());
                session.setAttribute("loginUserType", loginResult.getUserType());
                model.addAttribute("loginStatus", true);
                session.setAttribute("loginStatus", true);
                return "home";
        }else if(loginResult.getMessage().equals(Code.ERROR)){
            model.addAttribute("loginMessage","抱歉，您的登录密码错误！");
            return "login";
        }else{
            model.addAttribute("loginMessage","账户不存在，请检查您的用户名");
            return "login";
        }
    }

    /**
     * 注销操作
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/clearSession")
    public String indexInit(HttpSession session , HttpServletRequest request, HttpServletResponse response,Model model){
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies.length);
        for (Cookie cookie : cookies){
            if(cookie.getName().equals("drivingUser")){
                Cookie remove = new Cookie("drivingUser","");
                remove.setMaxAge(0);
                remove.setPath("/"+WebPathInitServlet.getCtx());
                response.addCookie(remove);
                break;
            }
        }
        session.removeAttribute("loginUsername");
        session.removeAttribute("loginUserId");
        session.removeAttribute("loginUserType");
        model.addAttribute("loginStatus",false);
        session.setAttribute("loginStatus", false);
        return "home";
    }

    private void addCookie(HttpServletResponse response, String cookieName, String cookieValue){
        Cookie cookie = new Cookie(cookieName, EnCodeUtil.Base64Encode(cookieValue));
        cookie.setMaxAge(7*24*60*60);
        cookie.setPath("/"+WebPathInitServlet.getCtx());
        response.addCookie(cookie);
    }
}
