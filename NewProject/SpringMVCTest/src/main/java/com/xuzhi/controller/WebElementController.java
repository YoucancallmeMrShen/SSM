package com.xuzhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/web")
public class WebElementController {

    //request元素
    @RequestMapping("request")
    public String request(WebRequest request){
        System.out.println(request.getParameter("test"));
        return "forward";
    }
    //session元素
    @RequestMapping("session")
    public String session(HttpSession session){
        session.setAttribute("test","我是你爸爸");
        return "forward";
    }
    //application元素
    @RequestMapping("application")
    public String application(HttpSession session){
        //获取application并设置test
        session.getServletContext().setAttribute("application","application测试");
        return "redirect:/jsp/forward.jsp";
    }
}
