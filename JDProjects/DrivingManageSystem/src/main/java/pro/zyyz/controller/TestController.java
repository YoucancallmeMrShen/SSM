package pro.zyyz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/tt")
    @ResponseBody
    public String test(HttpServletResponse response , HttpServletRequest request){
//        Cookie cookie = new Cookie("test","wangxuzhi");
//        response.addCookie(cookie);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            System.out.println(cookie.getName());
        }


        return "testr";
    }
}
