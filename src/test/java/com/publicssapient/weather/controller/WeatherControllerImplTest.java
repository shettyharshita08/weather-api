package com.publicssapient.weather.controller;

import com.publicssapient.weather.model.Weather;
import com.publicssapient.weather.model.WeatherForecast;
import com.publicssapient.weather.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherControllerImplTest {

    @InjectMocks
    private WeatherControllerImpl weatherController;

    @Mock
    private WeatherService weatherService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherByCity() {
        String city = "TestCity";
        List<WeatherForecast> weatherForecasts = new ArrayList<>();
        when(weatherService.getCityWeather(city, false)).thenReturn(weatherForecasts);

        ResponseEntity<Map<String, Object>> response = weatherController.getWeatherByCity(city, false);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(weatherForecasts, response.getBody().get("Weather"));
    }

    @Test
    public void testGetAllWeatherByCity() {
        String city = "TestCity";
        Weather weather = new Weather();
        when(weatherService.getAllCityWeather(city)).thenReturn(weather);

        ResponseEntity<Weather> response = weatherController.getAllWeatherByCity(city);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(weather, response.getBody());
    }
}