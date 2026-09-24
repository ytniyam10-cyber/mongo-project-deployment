package com.mongpro.mongo_project.repo;

import com.mongpro.mongo_project.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends MongoRepository<User,Integer> {
    User findByUsername(String username);
}
