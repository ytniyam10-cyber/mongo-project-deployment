package com.mongpro.mongo_project.SentimentAnal;

import com.mongpro.mongo_project.entities.Book;
import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.repo.UserRepo;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class PreLoader {
    @Autowired
    public UserRepo repo;

   Map<String, List<Book>> map = new HashMap<>();

   @PostConstruct
   public void pl(){
       List<User> list= repo.findAll();
       for(User user: list){
           if(user.isSentimentAnalysis())map.put(user.getUsername(),user.getBooks());
       }
   }
}
