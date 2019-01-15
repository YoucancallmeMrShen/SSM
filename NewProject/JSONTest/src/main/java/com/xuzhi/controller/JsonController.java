package com.xuzhi.controller;

import com.xuzhi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/json")
public class JsonController {

    //返回一个pojo
    @RequestMapping("/m1")
    @ResponseBody  //这个注解将制定返回的不是视图，而是数据,他会将我们的返回数据格式转换为json数据格式
    public User json1(){
        User user=new User();
        user.setName("我是你爸爸");
        user.setPassword("root");
        return user;
    }

    //返回一个Map
    @RequestMapping("/m2")
    @ResponseBody  //这个注解将制定返回的不是视图，而是数据,他会将我们的返回数据格式转换为json数据格式
    public Map<String,Object> json2(){
        Map<String,Object> map=new HashMap<>();
        map.put("name","你爸爸就是你爸爸");
        map.put("age",21);
        return map;
    }

    @RequestMapping("/m3")
    @ResponseBody
    public User[] json3(){
        User user1=new User();
        user1.setName("我是你爸爸1");
        user1.setPassword("你爸爸");
        User user2=new User();
        user2.setName("你爸爸就是你爸爸");
        user2.setPassword("你就是你");
        return new User[]{user1,user2};
    }


    @RequestMapping("/m4")
    @ResponseBody
    public List<User> json4(){
        List<User> list=new ArrayList<>();
        User user1=new User();
        user1.setName("我是你爸爸");
        user1.setPassword("你爸爸");
        User user2=new User();
        user2.setName("你爸爸就是你爸爸");
        user2.setPassword("你就是你");
        list.add(user1);
        list.add(user2);
        return list;
    }

    @RequestMapping("/m5")
    @ResponseBody
    public List<Map<String,User>> json5(){
        List<Map<String,User>> list=new ArrayList<>();
        Map<String,User> map=new HashMap<>();
        User user1=new User("user1","123");
        User user2=new User("user2","234");
        map.put("user1",user1);
        map.put("user2",user2);
        Map<String,User> map1=new HashMap<>();
        User user3=new User("user3","345");
        User user4=new User("user4","456");
        map1.put("user3",user3);
        map1.put("user4",user4);
        list.add(map);
        list.add(map1);
        return list;
    }




}
