package com.mongpro.mongo_project.services;

import com.mongpro.mongo_project.ApiConstruct;
import com.mongpro.mongo_project.respone.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    @Value("${weather.api.key}")
    public String apiKey ;

    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public ApiConstruct apiConstruct;

    public WeatherResponse fn(String city){
      
        String finalAPI= apiConstruct.getMap().get("weather_api").replace("YOUR_API_KEY",apiKey).replace("CITY",city);
        ResponseEntity<WeatherResponse> weather = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = weather.getBody();
        return body;
    }

}
