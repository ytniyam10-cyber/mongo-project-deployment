package com.mongpro.mongo_project.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class configure_api {
    public String key;
    public String value;
}
