package com.publicssapient.weather.controller;

import com.publicssapient.weather.exception.ApplicationException;
import com.publicssapient.weather.exception.ErrorCode;
import com.publicssapient.weather.model.Weather;
import com.publicssapient.weather.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class WeatherControllerImpl implements WeatherController {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherControllerImpl.class);

    @Autowired
    private WeatherService weatherService;

    @Override
    public ResponseEntity<Map<String, Object>> getWeatherByCity(String city, boolean isChecked) {
        LOG.info("[getWeatherByCity] Started for City : {}", city);
        try {
            if (city != null) {
                Map<String, Object> response = new HashMap<>();
                response.put("Weather", weatherService.getCityWeather(city, isChecked));
                response.put("Link", linkTo(methodOn(WeatherControllerImpl.class).getAllWeatherByCity(city)).withRel("all-weather"));
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                LOG.error("[getWeatherByCity] Exception occurred while passing null value for city");
                throw new ApplicationException(ErrorCode.ERROR_CODE_1.getMessage());
            }
        } catch (Exception e) {
            LOG.error("[getWeatherByCity] Exception occurred while getting weather for city : {}", e.getMessage());
            throw new ApplicationException(ErrorCode.ERROR_CODE_1.getMessage());
        }
    }

    @Override
    public ResponseEntity<Weather> getAllWeatherByCity(String city) {
        LOG.info("[getAllWeatherByCity] Started for City : {}", city);
        try {
            if (city != null) {
                return new ResponseEntity<>(weatherService.getAllCityWeather(city), HttpStatus.OK);
            } else {
                LOG.error("[getAllWeatherByCity] Exception occurred while passing null value for city");
                throw new ApplicationException(ErrorCode.ERROR_CODE_1.getMessage());
            }
        } catch (Exception e) {
            LOG.error("[getAllWeatherByCity] Exception occurred while getting weather for city : {}", e.getMessage());
            throw new ApplicationException(ErrorCode.ERROR_CODE_1.getMessage());
        }
    }
}
