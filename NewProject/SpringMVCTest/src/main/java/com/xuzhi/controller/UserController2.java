package com.xuzhi.controller;

import com.xuzhi.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user2")
public class UserController2 {

//    //就是在controller里面的任意一个处理具体的方法之前执行
//    @ModelAttribute
//    public User init(){
//        User u=new User();
//        u.setName("王是你爸爸");
//        return u;
//    }
    //就是在controller里面的任意一个处理具体的方法之前执行
    @ModelAttribute
    public void init(Model model){
        User u=new User();
        u.setName("王是你爸爸");
        model.addAttribute("user",u);
    }
    @RequestMapping("/model")
    public String model(Model model){
        //判断init（）方法是否在该方法之前执行，即判断init（）方法是否返回了User对象，同时确定了init（）返回的对象名是什么
        System.out.println(model.containsAttribute("user"));
        System.out.println(model.addAttribute("user"));
        return "msg";
    }
    //如果前台没有传过来相应的值，使用该注解后会自动去我们的model模型中寻找相应的user，
    //如果前台传值过来，则init（）方法返回的内容则由前台穿过来的model模型替换
    @RequestMapping("/model2")
    public String model2(@ModelAttribute User user){
        System.out.println(user.getName()+user.getPassword());
        return "msg";
    }

    @InitBinder("user")
    public void init(WebDataBinder webDataBinder){
        //这里指定什么格式，前台就传什么格式
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,false));
    }
    @PostMapping("/model3")
    public String model3(@ModelAttribute("user") User user){
        System.out.println(user.getName()+user.getPassword());
        System.out.println(user.getBirth());
        return "msg";
    }

    @PostMapping("/model4")
    public String model4(User user){
        System.out.println(user.getName()+user.getPassword());
        System.out.println(user.getBirth());
        return "msg";
    }

}
