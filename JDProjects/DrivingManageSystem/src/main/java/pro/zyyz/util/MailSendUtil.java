package pro.zyyz.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class MailSendUtil {
    public static String emailFrom = "xuzhi7162@163.com";

    /**
     *
     * @param from => 邮件发送者
     * @param to => 邮件接收者
     * @param code => 验证码
     * @return 返回code => 用作验证
     */
    public static String mailSend(String from , String to , String code , JavaMailSender javaMailSender){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            //设置发件人邮箱
            mimeMessageHelper.setFrom(from);
            //设置收件人邮箱
            mimeMessageHelper.setTo(to);
            //设置邮件主题
            mimeMessageHelper.setSubject("驾校管理系统-验证码");
            //写入邮件的正文
            mimeMessageHelper.setText("<div id=\"content\" style=\"width: 600px;height: 400px;margin: 10px auto;background-color: #393d49;\">\n" +
                    "\t\t\t\t<div id=\"mailHead\" style=\"height: 40px;background-color: #23262e;\">\n" +
                    "\t\t\t\t\t<h2 style=\"color: white;padding: 5px 10px;\">XX驾校管理系统-验证码</h2>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t\t<div id=\"mailSection\" style=\"padding: 10px;\">\n" +
                    "\t\t\t\t\t<h3 style=\"color: #00FF00;\">亲爱的客户：</h3>\n" +
                    "\t\t\t\t\t<br />\n" +
                    "\t\t\t\t\t<p style=\"color: white;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您正在修改安全邮箱，请在验证码输入框中输入：<span style=\"color: red;font-size: larger;\">"+ code +"</span> ，以完成操作。</p>\n" +
                    "\t\t\t\t\t<br />\n" +
                    "\t\t\t\t\t<p style=\"color: #888888\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注意：此操作可能会修改您的密码、登录邮箱或绑定手机。如非本人操作，请及时登录并修改密码以保证帐户安全 （工作人员不会向你索取此验证码，请勿泄漏！)</p>\n" +
                    "\t\t\t\t</div>\n" +
                    "\t\t\t</div>" ,true);
            //发送邮件
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return code;
    }
}
