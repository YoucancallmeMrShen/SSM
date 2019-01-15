package com.xuzhi.controller;

import com.xuzhi.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/xml")
public class XmlController {

    //produces用于指定返回数据的数据类型，在这里我们指定为XML格式
    @RequestMapping(value = "/m1",produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public User m1(){
        User user=new User();
        user.setName("我是你爸爸");
        user.setPassword("你爸爸就是你爸爸");
        return user;
    }
}
