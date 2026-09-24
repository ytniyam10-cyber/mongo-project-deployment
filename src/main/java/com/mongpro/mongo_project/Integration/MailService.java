package com.mongpro.mongo_project.Integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Autowired
    public JavaMailSender mailSender;

    public void sendmail(String finaltemp){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("a.niyamath7@gmail.com");
        message.setTo("ytniyam10@gmail.com");
        message.setSubject("Weather forecast of chennai");
        message.setText(finaltemp);

        mailSender.send(message);
    }
}
