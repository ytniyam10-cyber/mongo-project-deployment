package com.mongpro.mongo_project.repo;

import com.mongpro.mongo_project.entities.configure_api;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ApiRepository extends MongoRepository<configure_api, ObjectId> {
}
