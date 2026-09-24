package com.mongpro.mongo_project.Redis;

import com.mongpro.mongo_project.respone.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    public RedisService redisService;
    @Autowired
    public WeatherS weatherS;

    @GetMapping("/getname")
    public String getName(){
        return redisService.getname();
    }

    @PostMapping("/setname")
    public void setName(){
        redisService.setname();
    }

    @GetMapping("/weather/{city}")
    public String getweather(@PathVariable String city){
        WeatherResponse getweather = weatherS.getweather(city);
        double tempC = getweather.getCurrent().getTemp_c();
        return "The temperature in " +city +  " is about " + tempC;
    }
}
