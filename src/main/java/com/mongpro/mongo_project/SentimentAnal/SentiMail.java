package com.mongpro.mongo_project.SentimentAnal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SentiMail {
    @Autowired
    public JavaMailSender mailSender;

    public void sendmail(String sentiment, String mood){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("a.niyamath7@gmail.com");
        message.setTo("ytniyam10@gmail.com");
        message.setSubject(sentiment);
        message.setText(mood);

        mailSender.send(message);
    }
}
