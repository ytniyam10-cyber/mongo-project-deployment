package com.mongpro.mongo_project.repo;

import com.mongpro.mongo_project.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepo extends MongoRepository<Book,Integer> {
}
