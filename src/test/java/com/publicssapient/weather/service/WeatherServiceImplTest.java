package com.publicssapient.weather.service;

import com.publicssapient.weather.client.WeatherClient;
import com.publicssapient.weather.model.Weather;
import com.publicssapient.weather.model.WeatherForecast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

public class WeatherServiceImplTest {

    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Mock
    private WeatherClient weatherClient;

    @Mock
    private WeatherDetailsService weatherDetailsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCityWeather() {
        String city = "TestCity";
        Weather weather = new Weather();
        when(weatherClient.getWeather(city, false)).thenReturn(weather);

        List<WeatherForecast> expected = List.of(new WeatherForecast());

        doAnswer(invocation -> {
            List<WeatherForecast> list = invocation.getArgument(1);
            list.addAll(expected);
            return null;
        }).when(weatherDetailsService).getWeatherForecast(eq(weather), anyList());

        List<WeatherForecast> actual = weatherService.getCityWeather(city, false);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllCityWeather() {
        String city = "TestCity";
        Weather expected = new Weather();
        when(weatherClient.getWeather(city, true)).thenReturn(expected);

        Weather actual = weatherService.getAllCityWeather(city);

        assertEquals(expected, actual);
    }
}
