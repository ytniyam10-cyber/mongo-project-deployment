package com.mongpro.mongo_project.respone;

import lombok.Data;

@Data
public class WeatherResponse {

    public Current current;

    @Data
    public static class Current {
        public double temp_c;
        public int humidity;
        public double wind_kph;
    }
}
