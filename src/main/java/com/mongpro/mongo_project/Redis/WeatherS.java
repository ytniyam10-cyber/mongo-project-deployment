package com.mongpro.mongo_project.Redis;

import com.mongpro.mongo_project.respone.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherS {

    public String api="https://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=CITY";
    @Value("${weather.api.key}")
    public String apiKey;

    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public RedisService redisService;

    public WeatherResponse getweather(String city) {
        if (redisService.getWeather(city) != null) {
            return (WeatherResponse)redisService.getWeather(city);
        } else {
            String finalApi = api.replace("YOUR_API_KEY", apiKey).replace("CITY",city);
            ResponseEntity<WeatherResponse> exchange = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = exchange.getBody();
            redisService.setWeather(body,city);
            return body;

        }
    }
}
