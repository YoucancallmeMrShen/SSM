package pro.zyyz.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class CharsetTest {
    @Test
    public void test(){
        String error ="鏁版嵁鎺ュ彛璇锋眰寮傚父锛�error";
        try {
            String test = new String(error.getBytes(),"UTF-8");
            System.out.println(test);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
