package com.xuzhi.pojo;

import com.xuzhi.spring.Pay;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class People {
    private String name;
    private Integer age;
    private String[] friends;
    private List<Integer> numbers;
    private List<Girl> girls;
    private Set<Pay> pays;
    private Map<String,Girl> girlMap;

    public Map<String, Girl> getGirlMap() {
        return girlMap;
    }

    public void setGirlMap(Map<String, Girl> girlMap) {
        this.girlMap = girlMap;
    }

    public Set<Pay> getPays() {
        return pays;
    }

    public void setPays(Set<Pay> pays) {
        this.pays = pays;
    }

    public List<Girl> getGirls() {
        return girls;
    }

    public void setGirls(List<Girl> girls) {
        this.girls = girls;
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

    public String[] getFriends() {
        return friends;
    }

    public void setFriends(String[] friends) {
        this.friends = friends;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + Arrays.toString(friends) +
                ", numbers=" + numbers +
                ", girls=" + girls +
                ", pays=" + pays +
                '}';
    }
}
