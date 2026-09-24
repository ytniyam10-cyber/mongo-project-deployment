package com.mongpro.mongo_project.services;

import com.mongpro.mongo_project.entities.EmailBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    public JavaMailSender javaMailSender;

    public void sendEmail(EmailBody emailBody){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom(emailBody.getFrom());
        message.setTo(emailBody.getTo());
        message.setSubject(emailBody.getSubject());
        message.setText(emailBody.getText());
        javaMailSender.send(message);
    }

}
