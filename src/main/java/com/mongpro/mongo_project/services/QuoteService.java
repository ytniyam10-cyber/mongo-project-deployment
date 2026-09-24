package com.mongpro.mongo_project.services;

import com.mongpro.mongo_project.respone.QuoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QuoteService {
    String API = "https://zenquotes.io/api/random";

    @Autowired
    public RestTemplate restTemplate;

    public QuoteResponse quoto(){
        ResponseEntity<QuoteResponse[]> quote = restTemplate.exchange(API, HttpMethod.GET, null, QuoteResponse[].class);
        QuoteResponse[] body = quote.getBody();
        return body[0];

    }

}
