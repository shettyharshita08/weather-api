package com.publicssapient.weather.service;

import com.publicssapient.weather.client.WeatherClient;
import com.publicssapient.weather.exception.ApplicationException;
import com.publicssapient.weather.exception.ErrorCode;
import com.publicssapient.weather.model.Weather;
import com.publicssapient.weather.model.WeatherForecast;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherServiceImpl.class);
    static Weather weather;
    @Autowired
    private WeatherClient weatherClient;
    @Autowired
    private WeatherDetailsService weatherDetailsService;

    @Override
    public List<WeatherForecast> getCityWeather(String city, boolean isChecked) {
        LOG.trace("[getCityWeather] Started for city : {}", city);
        List<WeatherForecast> dayWeatherList = new ArrayList<>();
        try {
            if (!isChecked) {
                weather = weatherClient.getWeather(city, false);
            }
            weatherDetailsService.getWeatherForecast(weather, dayWeatherList);
        } catch (Exception e) {
            LOG.error("[getCityWeather] Exception occurred while getting weather : {}", e.getMessage());
            throw new ApplicationException(ErrorCode.ERROR_CODE_2.getMessage());
        }
        LOG.info("[getCityWeather] Completed for City : {}", city);
        return dayWeatherList;
    }

    @Override
    public Weather getAllCityWeather(String city) {
        LOG.trace("[getAllCityWeather] Started for city : {}", city);
        Weather weather = null;
        try {
            weather = weatherClient.getWeather(city, true);
        } catch (Exception e) {
            LOG.error("[getAllCityWeather] Exception occurred while getting weather : {}", e.getMessage());
            throw new ApplicationException(ErrorCode.ERROR_CODE_2.getMessage() + e.getMessage());
        }
        LOG.info("[getAllCityWeather] Completed for City : {}", city);
        return weather;
    }

}
