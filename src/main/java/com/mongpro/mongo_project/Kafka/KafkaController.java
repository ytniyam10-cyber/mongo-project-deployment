package com.mongpro.mongo_project.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private OrderProducer orderProducer;
    @Autowired
    private ReportService reportService;

    @PostMapping("/produce")
    public void send(@RequestBody Orders order){
        orderProducer.produce(order);
    }

//    @PostMapping("/report")
//    public void rep(){
//       reportService.niyam(); ;
//    }
}
