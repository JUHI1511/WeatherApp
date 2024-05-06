package com.example.demo.service;

import com.example.demo.bean.Weather;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeatherService {
    public Weather addWeather(Weather weather);

    public Weather viewWeatherByCity(String cityName);

    public Weather viewWeatherById(int weatherId);

    public List<Weather> viewAllWeather();

    public Weather updateWeather(Weather weather);

    public String deleteById(int weatherId);


}
