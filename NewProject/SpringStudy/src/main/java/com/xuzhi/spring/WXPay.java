package com.xuzhi.spring;

public class WXPay implements Pay {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
