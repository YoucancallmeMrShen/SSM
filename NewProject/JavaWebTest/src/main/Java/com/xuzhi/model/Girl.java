package com.xuzhi.model;

import java.io.Serializable;
import java.util.Date;

public class Girl implements Serializable {
    private long id;
    private String name;
    private String flower;
    private Date birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlower() {
        return flower;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Girl(String name, String flower){
        this.name=name;
        this.flower=flower;
    }
    public Girl(){

    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flower='" + flower + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
