package com.mongpro.mongo_project.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {
    @Autowired
    private KafkaTemplate<String,Orders> kafkaTemplate;

    public void produce(Orders s){
        kafkaTemplate.send("orders",s);
    }
}
