package com.xuzhi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("test")
public class AnnotationsController {


    //请求映射的路径path可以有多个值，即请求这个controller可以用多个名字，m1，m2都可以请求这个Controller
//    @RequestMapping(value = {"/m1","/m2"})
//    @RequestMapping(path = {"/m1","/m2"})
    //该请求只能接受post提交的表单
    @RequestMapping(path = {"/m1","/m2"},method = RequestMethod.POST)
    public String m1(Model model){
        model.addAttribute("annotations","@RequestMapping注解");
        return "annotations";
    }

    //用以处理post请求，参数为两个，分别为a和b
    @RequestMapping(path = "/m2",method = RequestMethod.GET,params = {"a","b"})
    public String m2(@RequestParam("a")Integer a, @RequestParam("b") Integer b){
        System.out.println(a+b);
        return "annotations";
    }

//    访问地址可以写为"/test/m3"+"任意单个字符，/除外"
//    @RequestMapping(path = "/m3?")
//    访问地址可以写为"/test/m3"+"可以放任意长度的字符串，但是不能包括/"
//    @RequestMapping(path = "m3*")
//    访问地址可以写为"/m3"+"/a"+"/b",可以有多层路径
    @RequestMapping(path = "m3/**")
    public String m3(){
        System.out.println("m3....");
        return "annotations";
    }
}
