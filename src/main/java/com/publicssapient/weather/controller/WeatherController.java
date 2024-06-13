package com.publicssapient.weather.controller;

import com.publicssapient.weather.model.Weather;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/weather")
@Tag(name = "Weather API", description = "To Showcase Low & Maximum Temperature in Celsius , Safety Message for weather condition with time intervals for Any City")
public interface WeatherController {

    @CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "Get Operation on Weather API for next 3 days", description = "Used to get Low & Maximum Temperature in Celsius , Safety Message for weather condition with time intervals for Given City for next 3 days including today's weather forecast.")
    @GetMapping("/getWeatherByCity")
    ResponseEntity<Map<String, Object>> getWeatherByCity(@RequestParam(value = "city") String city, @RequestParam(value = "isChecked") boolean isChecked);

    @GetMapping("/getAllWeatherByCity")
    @Operation(summary = "Get Operation on Weather API with detailed information for next 4 days", description = "Used to get detailed weather information for given city for 4 days including today's weather forecast.")
    ResponseEntity<Weather> getAllWeatherByCity(@RequestParam(value = "city") String city);
}
