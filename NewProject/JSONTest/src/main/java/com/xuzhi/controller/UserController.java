package com.xuzhi.controller;

import com.xuzhi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/login")
    public String login(User user, HttpSession session){
        System.out.println(user.getName()+user.getPassword());
        System.out.println("login.......");
        session.setAttribute("SESSION_USER",user);
        return "user";
    }
}
