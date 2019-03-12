package pro.zyyz.util;

public class Code {
    /**
     * 通用正确&错误码
     */
    public static String SUCCESS = "success";
    public static String ERROR = "error";
    public static String ERROR_NULL = "null";

    /**
     * 邮件发送
     * 邮件发送成功 => 1001
     * 邮件发送失败 => 1000
     */
    public static String MAIL_SEND_SUCCESS = "1001";
    public static String MAIL_SEND_ERROR = "1000";

    /**
     * 管理等级认定
     * 超级管理员(MANAGE_ONE) => 2001
     * 一级管理员(MANAGE_TWO) => 2002
     * 三级管理员(MANAGE_THREE) => 2003 => 默认
     */
    public static String MANAGE_ONE = "2001";
    public static String MANAGE_Two = "2002";
    public static String MANAGE_Three = "2003";


}
