package pro.zyyz.util;

import net.sf.json.JSONObject;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie处理工具类
 */
public class CookieUtil {

    /**
     * 向浏览器发送一个cookie,并对该cookie进行加密处理
     * @param response 调用response的addCookie()方法在浏览器添加cookie
     * @param cookieName 设置cookie的name属性
     * @param cookieValue 设置cookie的value值
     * @param cookieTime 设置cookie的有效期,单位为天
     * @return 返回一个cookie
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, int cookieTime){

        Cookie cookie = new Cookie(EnCodeUtil.Base64Encode( cookieName ),EnCodeUtil.Base64Encode(cookieValue));
        cookie.setMaxAge( cookieTime*24*60*60 );
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

    }

    /**
     * 从浏览器取回Cookie
     * @param request 调用request的getCookies()方法
     * @param cookieName 相应cookie的name值
     * @return 返回JSONObject对象
     */
    public static JSONObject getCookie(HttpServletRequest request, String cookieName ){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if(EnCodeUtil.Base64Decode(cookie.getName()).equals(cookieName)){
                JSONObject jsonObject = JSONObject.fromObject( EnCodeUtil.Base64Decode( cookie.getValue() ) );
                return jsonObject;
            }
        }
        return null;
    }

    /**
     * 删除不需要的Cookie
     * @param request
     * @param response
     * @param cookieName 需要删除cookie的name值
     */
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if( EnCodeUtil.Base64Decode( cookie.getName() ).equals( cookieName) ){
                cookie.setMaxAge(0);
                break;
            }
        }
    }
}
