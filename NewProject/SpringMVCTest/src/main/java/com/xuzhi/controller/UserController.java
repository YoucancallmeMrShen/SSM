package com.xuzhi.controller;

import com.xuzhi.pojo.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

    @PutMapping("/put")
    @ResponseBody
    public String put(String name){
        System.out.println(name);
        return "@PutMapping测试成功";
    }

    @PutMapping("/put1")
    @ResponseBody
    public String put1(@RequestParam("name") String name){
        System.out.println(name);
        return "@PutMapping测试成功";
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,false));

    }
    @PutMapping("/put2")
    @ResponseBody
    public String put2(User user){
        System.out.println(user.getName()+user.getPassword());
        System.out.println(user.getBirth());
        return "@PutMapping测试成功";
    }
}
