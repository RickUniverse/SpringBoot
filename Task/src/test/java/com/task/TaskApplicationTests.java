package com.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() throws MessagingException {

        // 1，创建复杂的邮件操作
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper hepler = new MimeMessageHelper(mimeMessage,true);
        //邮件设置
        hepler.setSubject("标题");
        hepler.setText("<b style='color:red'>开会！！！！！！</b>",true);

        hepler.setTo("2388948195@qq.com");
        hepler.setFrom("rickuniverse@163.com");

        hepler.addAttachment("Postman.exe",new File("C:\\Users\\Rick\\AppData\\Local\\Postman\\Postman.exe"));
//        hepler.addAttachment("Postman.exe",new File("D:\\Video\\August.Osage.County.八月.奥色治郡.2013.中英字幕.BDrip.1080P-人人影视.mp4"));

        mailSender.send(mimeMessage);

    }

}
