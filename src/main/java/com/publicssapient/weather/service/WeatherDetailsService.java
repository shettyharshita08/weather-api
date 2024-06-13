package com.publicssapient.weather.service;

import com.publicssapient.weather.constants.WeatherConstants;
import com.publicssapient.weather.exception.ApplicationException;
import com.publicssapient.weather.exception.ErrorCode;
import com.publicssapient.weather.model.Weather;
import com.publicssapient.weather.model.WeatherForecast;
import com.publicssapient.weather.model.WeatherObjectList;
import com.publicssapient.weather.util.WeatherUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(WeatherDetailsService.class);

    public void getWeatherForecast(Weather weather, List<WeatherForecast> dayWeatherList) {
        LOG.info("[getWeatherForecast] Started for city : {}", weather.getCity());
        try {
            List<WeatherObjectList> threeDaysCityWeather = weather.getList();
            threeDaysCityWeather.forEach(weatherObjectList -> {
                WeatherForecast weatherForecast = new WeatherForecast();
                if (weatherObjectList.getMain() != null) {

                    weatherForecast.setHumidity(weatherObjectList.getMain().getHumidity());
                    weatherForecast.setWind(weatherObjectList.getWind().getSpeed());

                    float temperatureInCelsius = WeatherUtil.convertTempToCelsius(weatherObjectList.getMain().getTemp());
                    getWeatherHighAndLowTemp(weatherForecast, weatherObjectList);

                    if (temperatureInCelsius > WeatherConstants.MAX_TEMPERATURE) {
                        weatherForecast.setMessage(WeatherConstants.USE_SUNSCREEN_LOTION);
                    } else if (weatherObjectList.getWeather().getFirst().getMain().contains(WeatherConstants.RAIN)) {
                        weatherForecast.setMessage(WeatherConstants.CARRY_UMBRELLA);
                    } else if (weatherObjectList.getWind().getSpeed() > WeatherConstants.MAX_WIND_SPEED) {
                        weatherForecast.setMessage(WeatherConstants.WIND_SPEED);
                    } else if ((weatherObjectList.getWeather().getFirst().getIcon().contains(WeatherConstants.MAX_THUNDERSTORM))) {
                        weatherForecast.setMessage(WeatherConstants.THUNDERSTORM);
                    } else {
                        weatherForecast.setMessage(weatherObjectList.getWeather().getFirst().getMain() + " Sky");
                    }
                }
                dayWeatherList.add(weatherForecast);
            });
        } catch (Exception e) {
            LOG.error("[getWeatherForecast] Exception occurred while getting weather forecast : {}", e.getMessage());
            throw new ApplicationException(ErrorCode.ERROR_CODE_3.getMessage());
        }
        LOG.info("[getWeatherForecast] Completed for city : {}", weather.getCity());
    }

    public void getWeatherHighAndLowTemp(WeatherForecast weatherForecast, WeatherObjectList weatherObjectList) {
        LOG.info("[getWeatherHighAndLowTemp] Started");
        weatherForecast.setHigh(WeatherUtil.convertTempToCelsius(weatherObjectList.getMain().getTemp_max()));
        weatherForecast.setLow(WeatherUtil.convertTempToCelsius(weatherObjectList.getMain().getTemp_min()));
        weatherForecast.setDate(weatherObjectList.getDt_txt());
        LOG.info("[getWeatherHighAndLowTemp] Completed ");
    }
}
