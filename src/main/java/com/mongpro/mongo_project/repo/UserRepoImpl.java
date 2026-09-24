package com.mongpro.mongo_project.repo;

import com.mongpro.mongo_project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepoImpl {
    @Autowired
    public MongoTemplate mongoTemplate;

    public List<User> findUsers(){
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is("shyam"));
        List<User> users = mongoTemplate.find(query, User.class);
        return users;

    }

}
