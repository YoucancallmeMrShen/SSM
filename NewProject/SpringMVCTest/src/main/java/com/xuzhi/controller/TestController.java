package com.xuzhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    //请求
    @RequestMapping("/forward")
    public String forward(Model model){
        //springmvc model默认是在请求域中存储值
        System.out.println("请求");
        model.addAttribute("skill","请求测试");
        return "forward";
    }

    //重定向
    @RequestMapping("/redirect")
    public String redirect(Model model){
        model.addAttribute("skill","重定向测试");
        System.out.println("重定向");
        return "redirect:/jsp/redirect.jsp";
    }

}
