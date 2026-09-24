package com.mongpro.mongo_project.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReportProducer {
    @Autowired
    public KafkaTemplate<String,Report> template;

    public void reportprod(Report report){
        template.send("reports",report);
    }
}
