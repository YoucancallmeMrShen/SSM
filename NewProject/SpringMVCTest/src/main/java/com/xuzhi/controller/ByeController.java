package com.xuzhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//使用注解需要在springmvc的配置文件里面导入一个包，以启动注解扫描
//不需要继承任何的类也不需要实现任何的接口
@Controller
@RequestMapping("/bye")
public class ByeController {
    //要想访问该Controller具体的地址应该是":8080/bye/bye"
    @RequestMapping("/bye")
    public String bye(Model model){
        model.addAttribute("hello","我的世界");
        //返回的为viewName,即视图的名字,此时寻找视图的路径为 /jsp/hello.jsp
        return "hello";
    }
}
