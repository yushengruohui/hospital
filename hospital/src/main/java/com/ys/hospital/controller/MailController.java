package com.ys.hospital.controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Description:
 * @author: yusheng
 * @create-date: 2019-10-08 23:20
 **/
@Controller
@RequestMapping("/mail")
public class MailController {
    @Resource
    private JavaMailSender javaMailSender;

    @RequestMapping("/active")
    public String active() {
        //简单邮件信息
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        //标题
        message.setSubject("这是你的激活码");
        //内容
        message.setText("asdfvcxz");
        //接受人的邮箱
        message.setTo("2239557880@qq.com");
        //发送人的邮箱
        message.setFrom("2091311046@qq.com");
        //发送
        javaMailSender.send(message);
        return "/";
    }

    @RequestMapping("/active2")
    public String demo2() throws MessagingException {
        //复杂邮件信息
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        //标题
        helper.setSubject("办公文件");
        //内容
        helper.setText("注意接送附件<br>", true);
        //接受人的邮箱
        helper.setTo("2239557880@qq.com");
        //发送人的邮箱
        helper.setFrom("2091311046@qq.com");
        helper.addAttachment("1.jpg", new File("G:\\picture\\1.jpg"));
        //发送
        javaMailSender.send(mimeMessage);
        return "/";
    }
}
