package com.mongpro.mongo_project;

import com.mongpro.mongo_project.entities.configure_api;
import com.mongpro.mongo_project.repo.ApiRepository;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Data
public class ApiConstruct {
    @Autowired
    public ApiRepository apiRepository;

    Map<String,String> map = new HashMap<>();

    @PostConstruct
    public void init(){
        List<configure_api> list = apiRepository.findAll();
        for(configure_api mes :list){
            map.put(mes.getKey(),mes.getValue());
        }
    }

}
