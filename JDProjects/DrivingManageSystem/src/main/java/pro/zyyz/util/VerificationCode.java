package pro.zyyz.util;


import java.util.Random;

public class VerificationCode {

    /**
     * 产生六位随机数
     * @return
     */
    public static String randomCode(){
        int random = (int)((Math.random()*9+1)*100000);
        return String.valueOf(random);
    }

}
