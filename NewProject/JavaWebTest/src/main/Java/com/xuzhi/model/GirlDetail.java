package com.xuzhi.model;

import java.io.Serializable;

public class GirlDetail extends Girl{
    private GirlWithDetail girlWithDetail;

    public GirlWithDetail getGirlWithDetail() {
        return girlWithDetail;
    }

    public void setGirlWithDetail(GirlWithDetail girlWithDetail) {
        this.girlWithDetail = girlWithDetail;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", flower='" + getFlower() + '\'' +
                ", birthday=" + getBirthday() +
                '}'+
                "GirlDetail{" +
                "girlWithDetail=" + girlWithDetail +
                '}';
    }
}
