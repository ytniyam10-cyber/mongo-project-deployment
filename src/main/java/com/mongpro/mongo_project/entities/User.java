package com.mongpro.mongo_project.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
@Data
public class User {

    @Id
    public int id;
    @Indexed(unique = true)
    public String username;
    public String pass;
    public boolean sentimentAnalysis;
    @DBRef
    List<Book> books= new ArrayList<>();
    List<String>Roles = new ArrayList<>();

}
