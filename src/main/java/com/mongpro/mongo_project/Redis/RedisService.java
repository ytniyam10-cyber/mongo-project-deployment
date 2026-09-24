package com.mongpro.mongo_project.Redis;

import com.mongpro.mongo_project.respone.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void setname(){
        redisTemplate.opsForValue().set("name","shyam");
    }
    public String getname(){
        return redisTemplate.opsForValue().get("name").toString();
    }

    public Object getWeather(String city){
        Object weather = redisTemplate.opsForValue().get(city);
        return weather;
    }
    public void setWeather(WeatherResponse response,String city){
        redisTemplate.opsForValue().set(city,response,5, TimeUnit.MINUTES);
    }
}
