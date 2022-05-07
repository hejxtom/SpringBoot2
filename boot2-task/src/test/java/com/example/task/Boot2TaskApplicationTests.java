package com.example.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Boot2TaskApplicationTests {


    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        消息头
        mailMessage.setSubject("通知-今晚开会");
//        消息内容
        mailMessage.setText("今晚7:30开会");
//        发给谁
        mailMessage.setTo("hejxtom@163.com");
//        谁发的
        mailMessage.setFrom("hejxtom@yeah.net");

//        发送
        mailSender.send(mailMessage);
    }


    @Test
    void test02() throws MessagingException {
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知-今晚开会");
        helper.setText("今晚7:30开会");
        helper.setTo("hejxtom@163.com");
        helper.setFrom("hejxtom@yeah.net");

        //上传文件
        helper.addAttachment("1.jpg",new File("C:\\Users\\hejx\\Pictures\\Saved Pictures\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\hejx\\Pictures\\Saved Pictures\\2.jpg"));

        mailSender.send(mimeMessage);

    }

}
