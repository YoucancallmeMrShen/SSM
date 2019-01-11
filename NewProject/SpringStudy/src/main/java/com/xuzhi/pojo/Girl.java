package com.xuzhi.pojo;

import com.xuzhi.spring.Pay;

public class Girl {
    private String name;
    private Integer age;
    private Pay pay;

    public Girl(){

    }

    public Girl(String name, Pay pay) {
        this.name = name;
        this.pay = pay;
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public void clearDress(){
        System.out.println("我要卸妆了。。。。");
    }
    public void dress(){
        System.out.println("早晨起来化妆");
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
