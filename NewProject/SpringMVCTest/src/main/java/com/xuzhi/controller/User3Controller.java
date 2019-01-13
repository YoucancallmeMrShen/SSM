package com.xuzhi.controller;

import com.xuzhi.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user3")
//@SessionAttributes("user")
public class User3Controller {
    @PostMapping("/session")
    public String session(@SessionAttribute User user){
        return "redirect:/jsp/user.jsp";
    }
}
