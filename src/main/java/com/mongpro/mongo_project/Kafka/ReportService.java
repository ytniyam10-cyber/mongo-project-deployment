package com.mongpro.mongo_project.Kafka;

import com.mongpro.mongo_project.SentimentAnal.PreLoader;
import com.mongpro.mongo_project.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportService {
    @Autowired
    public PreLoader preLoader;
    @Autowired
    public ReportProducer producer;

  //  @Scheduled(cron = "0 * * * * *")
    public void niyam(){
        Map<String , List<Book>> map=preLoader.getMap();

        for(String key : map.keySet()){
            int happy=0,sad=0;
            for(Book bk:map.get(key)){
                if(bk.getSentiment().equals("happy"))happy++;
                else if (bk.getSentiment().equals("sad"))sad++;
            }
            String x="";
            if(happy>sad)x="happy";
            else x="sad";
            Report report =new Report(key,x);
            producer.reportprod(report);
        }
    }


}
