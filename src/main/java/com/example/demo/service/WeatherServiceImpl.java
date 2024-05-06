package com.example.demo.service;

import com.example.demo.bean.Weather;
import com.example.demo.dao.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService{
    @Autowired
    private WeatherRepository weatherRepository;


    @Override
    public Weather addWeather(Weather weather) {
        weatherRepository.save(weather);
        return weather;
    }

    @Override
    public Weather viewWeatherByCity(String cityName) {
        return null;
    }

    @Override
    public Weather viewWeatherById(int weatherId) {
        Weather weather = (Weather)weatherRepository.findById(weatherId).get();
        return weather;
    }

    @Override
    public List<Weather> viewAllWeather() {
        List<Weather> weatherList= weatherRepository.findAll();
        return weatherList;
    }

    @Override
    public Weather updateWeather(Weather weather) {
        int weatherId = weather.getWeatherId();
        Weather weather1= weatherRepository.findById(weatherId).get();
        weather1.setTemp(weather.getTemp());
        weather1.setDescription(weather.getDescription());
        weather1.setCityName((weather.getCityName()));
        weatherRepository.save(weather1);
        return weather1;

    }

    @Override
    public String deleteById(int weatherId) {
        if (weatherRepository.findById(weatherId).isPresent()){
            weatherRepository.deleteById(weatherId);
        return "Car Deleted Successfully";
        }
        return "No records found";
    }
}
