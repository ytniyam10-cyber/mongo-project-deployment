package com.mongpro.mongo_project.Kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    public int id;
    public String item;
    public int amount;
}
