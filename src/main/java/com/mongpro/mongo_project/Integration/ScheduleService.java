package com.mongpro.mongo_project.Integration;

import com.mongpro.mongo_project.respone.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {
    @Autowired
    public Weather weather;
    @Autowired
    public MailService mailService;

    //@Scheduled(cron = "0 * * * * *")
    public void scheduling(){
        WeatherResponse getweather = weather.getweather();
        double tempC = getweather.getCurrent().getTemp_c();
        int humidity = getweather.getCurrent().getHumidity();
        double windKph = getweather.getCurrent().getWind_kph();
        String finaltemp= " The temperature in chennai right now is " +  tempC;
        mailService.sendmail(finaltemp);
    }
}
