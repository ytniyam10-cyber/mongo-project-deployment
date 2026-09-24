package com.mongpro.mongo_project.entities;

import lombok.Data;

@Data
public class EmailBody {
    public String to;
    public String from;
    public String subject;
    public String text;
}
