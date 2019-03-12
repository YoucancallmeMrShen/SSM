package pro.zyyz.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class EnCodeUtil {

    /**
     * 负责对字符串进行Base64加密
     * @param inCode  要加密的字符串
     * @return 返回加密后的字符串
     */
    public static String Base64Encode(String inCode){
        return Base64.encodeBase64String(inCode.getBytes());
    }

    /**
     * 对Base64加密的字符串进行解密并返回
     * @param inCode   输入Base64加密的字符串
     * @return 返回解密后的原字符串
     */
    public static String Base64Decode(String inCode){
        return new String(Base64.decodeBase64(inCode.getBytes()));
    }

    /**
     * 对字符串进行MD5加密
     * @param incode 原字符串
     * @return 输出MD5加密后的数据
     */
    public static String MD5Encode(String incode){
        return DigestUtils.md5Hex(incode);
    }
}
