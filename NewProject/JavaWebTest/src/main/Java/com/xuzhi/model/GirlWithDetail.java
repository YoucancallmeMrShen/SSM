package com.xuzhi.model;

import java.io.Serializable;

public class GirlWithDetail implements Serializable {
    private Integer gid;
    private String address;
    private Girl girl;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "GirlWithDetail{" +
                "gid=" + gid +
                ", address='" + address + '\'' +
                '}';
    }
}
