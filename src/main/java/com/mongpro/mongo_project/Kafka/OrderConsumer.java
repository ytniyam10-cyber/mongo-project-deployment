package com.mongpro.mongo_project.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    @KafkaListener(topics = "orders", groupId = "orders-group-2",autoStartup = "false")
    public void consume(Orders s){
        System.out.println("Recieved message:");
        System.out.println("id: " + s.getId());
        System.out.println("item: "+ s.getItem());
        System.out.println("amount: " + s.getAmount());
    }

}
