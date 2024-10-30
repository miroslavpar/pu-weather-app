package com.pu.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import com.pu.weather.WeatherResponse;

@Controller
public class WeatherController {

    @Value("${openweather.api.key}")
    private String apiKey;

    private final String baseUrl = "http://api.openweathermap.org/data/2.5/weather";

    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("%s?q=%s&appid=%s&units=metric", baseUrl, city, apiKey);

        try {
            WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
            model.addAttribute("weather", weatherResponse);
        } catch (Exception e) {
            model.addAttribute("error", "Градът не беше намерен!");
        }
        return "index";
    }
}
