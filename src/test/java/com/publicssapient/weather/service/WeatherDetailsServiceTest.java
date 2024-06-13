package com.publicssapient.weather.service;

import com.publicssapient.weather.model.Main;
import com.publicssapient.weather.model.Weather;
import com.publicssapient.weather.model.WeatherForecast;
import com.publicssapient.weather.model.WeatherObjectList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WeatherDetailsServiceTest {

    @InjectMocks
    private WeatherDetailsService weatherDetailsService;

    @Mock
    private Weather weather;

    @Mock
    private WeatherObjectList weatherObjectList;

    @Mock
    private Main main;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherForecast() {
        List<WeatherObjectList> threeDaysCityWeather = new ArrayList<>();
        when(weather.getList()).thenReturn(threeDaysCityWeather);

        List<WeatherForecast> dayWeatherList = new ArrayList<>();
        weatherDetailsService.getWeatherForecast(weather, dayWeatherList);

        assertEquals(threeDaysCityWeather.size(), dayWeatherList.size());
    }

    @Test
    public void testGetWeatherHighAndLowTemp() {
        WeatherForecast weatherForecast = new WeatherForecast();

        when(weatherObjectList.getMain()).thenReturn(main);
        when(main.getTemp_max()).thenReturn(300.0F);
        when(main.getTemp_min()).thenReturn(280.0F);

        weatherDetailsService.getWeatherHighAndLowTemp(weatherForecast, weatherObjectList);
        Float highValue = Float.parseFloat(String.format("%.2f", weatherForecast.getHigh()));
        Float lowValue = Float.parseFloat(String.format("%.2f", weatherForecast.getLow()));

        assertEquals(26.85F, highValue);
        assertEquals(6.85F, lowValue);
    }
}