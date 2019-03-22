package com.my.spd.utils.Send;

import com.cloopen.rest.sdk.CCPRestSmsSDK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author 杨宇帆
 * @create 2019-03-19
 */
@Component
public class MessageSend {
    @Autowired
    private CCPRestSmsSDK ccpRestSmsSDK;

    @Autowired
    private JavaMailSender javaMailSender;

    private static final Logger logger = LoggerFactory.getLogger(MessageSend.class);
    @Async
    public void sendSMS(String phone,String Random){
//        logger.debug("时间:"+ new Date()+"手机号为:"+phone+"发送了一条短信,验证码为:"+Random);
        ccpRestSmsSDK.sendTemplateSMS(phone, "1", new String[]{Random,"1"});
    }

    @Async
    public void sendMail(String mail,String path){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null; //true代表要发送文件
        try {
            helper = new MimeMessageHelper(message, false);
            helper.setText(path,true);//true代码会转为html
            helper.setSubject("请验证您的账号,点击正文中的链接来激活您的账号");
            helper.setFrom("yangyufan199691@163.com");
            helper.setTo(mail);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
