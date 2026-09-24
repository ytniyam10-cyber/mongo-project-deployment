package com.mongpro.mongo_project.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReportConsumer {
    @Autowired
    public ReportMail reportMail;

    @KafkaListener(
            topics = "reports",
            groupId = "report-email-group",
            autoStartup = "false"
    )
    public void consume(Report report) {

        System.out.println("Report received:");
        System.out.println("Name: " + report.getName());
        System.out.println("Mood: " + report.getMood());
        reportMail.sendmail(report);
    }

}
