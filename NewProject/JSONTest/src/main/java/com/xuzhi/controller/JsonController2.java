package com.xuzhi.controller;

import com.xuzhi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/json2")
public class JsonController2 {

    //前台提交一个user过来
    @RequestMapping("/add")
    //User user入参只能处理form表单提交的数据
    //要想接收前台ajax发过来的json数据，需在入参时添加@RequestBody注解
    public String add(@RequestBody User user){
        System.out.println(user.getName()+user.getPassword());
        return "msg";
    }

    //前台提交一个user过来
    @RequestMapping("/addList")
    //User user入参只能处理form表单提交的数据
    //要想接收前台ajax发过来的json数据，需在入参时添加@RequestBody注解
    @ResponseBody
    public Map<String,Integer> addList(@RequestBody List<User> user){
        Map<String,Integer> map=new HashMap<>();
        map.put("code",2000);
        System.out.println(user);
        return map;
    }


}
