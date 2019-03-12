package pro.zyyz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pro.zyyz.util.MailSendUtil;
import pro.zyyz.util.VerificationCode;


@Controller
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping("/send")
    @ResponseBody
    public String emailSend(@RequestParam("email") String email){
        String verCode =  MailSendUtil.mailSend(MailSendUtil.emailFrom , email , VerificationCode.randomCode() , javaMailSender);
        return verCode;
    }

}
