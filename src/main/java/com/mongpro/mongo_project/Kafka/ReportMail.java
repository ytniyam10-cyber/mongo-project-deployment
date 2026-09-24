package com.mongpro.mongo_project.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ReportMail {
    @Autowired
    public JavaMailSender mailSender;

    public void sendmail(Report report){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("a.niyamath7@gmail.com");
        message.setTo("ytniyam10@gmail.com");
        String sentiment="Sentiment analysis of " + report.getName();
        String mood = "Your mood throughout the week is " + report.getMood();
        message.setSubject(sentiment);
        message.setText(mood);
        mailSender.send(message);
    }
}
