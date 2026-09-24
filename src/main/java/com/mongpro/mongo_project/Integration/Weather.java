package com.mongpro.mongo_project.Integration;

import com.mongpro.mongo_project.respone.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class Weather {

    public String api="https://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=Chennai";
    @Value("${weather.api.key}")
    public String apiKey;

    @Autowired
    public RestTemplate restTemplate;

    public WeatherResponse getweather(){
        String finalApi=api.replace("YOUR_API_KEY",apiKey);
        ResponseEntity<WeatherResponse> exchange = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
        WeatherResponse body = exchange.getBody();
        return body;

    }

}
