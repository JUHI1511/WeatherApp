package com.example.demo.controller;

import com.example.demo.bean.Weather;
import com.example.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping(path = "/addweather")
    public ResponseEntity<Weather> addWeather(@RequestBody Weather weather)  {
        return new ResponseEntity<>(weatherService.addWeather(weather), HttpStatus.OK);

    }

    @GetMapping(path = "/getweather/{weatherId}")
    public ResponseEntity<Weather> viewWeather(@PathVariable int weatherId) {
        return new ResponseEntity<>(weatherService.viewWeatherById(weatherId), HttpStatus.OK);

    }

    @GetMapping(path = "/getweather")
    public ResponseEntity<List<Weather>> viewAllWeather() {
        return new ResponseEntity<>(weatherService.viewAllWeather(), HttpStatus.OK);
    }

    @PutMapping(path = "/updateweather")
    public ResponseEntity<Weather> updateWeather(@RequestBody Weather weather) {
        return new ResponseEntity<>(weatherService.updateWeather(weather), HttpStatus.OK);

    }

    @DeleteMapping(path = "/deleteweather/{weatherId}")
    public ResponseEntity<String> deleteCar(@PathVariable int weatherId) {
        weatherService.deleteById(weatherId);
        String message = "Weather Details of a City Deleted Successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);

    }
}
