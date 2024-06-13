package com.publicssapient.weather.service;

import com.publicssapient.weather.model.Weather;
import com.publicssapient.weather.model.WeatherForecast;

import java.util.List;

public interface WeatherService {

    List<WeatherForecast> getCityWeather(String city, boolean isChecked);

    Weather getAllCityWeather(String city);
}
