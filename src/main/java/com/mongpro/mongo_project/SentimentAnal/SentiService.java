package com.mongpro.mongo_project.SentimentAnal;

import com.mongpro.mongo_project.entities.Book;
import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SentiService {
    @Autowired
    public UserRepo userRepo;
    @Autowired
    public SentiMail mail;
    @Autowired
    public PreLoader preLoader;

  //  @Scheduled(cron = "0 * * * * *")
    public void senti(){
        Map<String,List<Book>> mp= preLoader.getMap();
        for(String key: mp.keySet()){
            int happy=0,sad=0;
            for(Book bk: mp.get(key)){
                if(bk.getSentiment().equals("happy"))happy++;
                else if (bk.getSentiment().equals("sad"))sad++;
            }
            String x="";
                if(happy>sad)x="happy";
                else x="sad";
                String sentiment="Sentiment analysis of " + key;
                String mood= "Your mood throught the week is " + x;
                mail.sendmail(sentiment,mood);
        }


    }

 //   @Scheduled(cron = "0 * * * * *")
//    public void senti(){
//        List<User> users = userRepo.findAll();
//        for(User mamu:users){
//            if(mamu.isSentimentAnalysis()){
//                int happy=0, sad=0;
//                List<Book> books = mamu.getBooks();
//                for(Book entry:books){
//                    if(entry.getSentiment().equals("happy"))happy++;
//                    else if(entry.getSentiment().equals("sad"))sad++;
//                }
//                String x="";
//                if(happy>sad)x="happy";
//                else x="sad";
//                String sentiment="Sentiment analysis of " + mamu.getUsername();
//                String mood= "Your mood throught the week is " + x;
//                mail.sendmail(sentiment,mood);
//            }
//        }
//    }
}
