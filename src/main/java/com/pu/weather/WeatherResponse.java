package com.pu.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    public String name;
    public Main main;
    public Weather[] weather;

    public static class Main {
        public double temp;
    }

    public static class Weather {
        public String description;
    }
}

