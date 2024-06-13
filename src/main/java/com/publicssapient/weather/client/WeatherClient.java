package com.publicssapient.weather.client;

import com.publicssapient.weather.exception.ApplicationException;
import com.publicssapient.weather.exception.ErrorCode;
import com.publicssapient.weather.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {
    private static final Logger LOG = LoggerFactory.getLogger(WeatherClient.class);

    @Value("${weather.api.url}")
    public String weatherApiUrl;

    @Value(("${weather.api.key}"))
    public String weatherApiKey;

    @Autowired
    RestTemplate restTemplate;

    public Weather getWeather(String city, boolean isAllWeather) {
        LOG.info("[getWeather] Started for City : {}", city);
        String url;
        if (!isAllWeather) {
            url = weatherApiUrl + city + "&appid=" + weatherApiKey + "&cnt=32";
        } else {
            url = weatherApiUrl + city + "&appid=" + weatherApiKey;
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            ResponseEntity<Weather> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), Weather.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                LOG.info("[getWeather] Completed for city : {} with response : {}", city, response.getBody());
                return response.getBody();
            } else {
                LOG.error("!2XX From [getWeather] API - " + url);
                throw new ApplicationException(ErrorCode.ERROR_CODE_2.getMessage());
            }
        } catch (Exception e) {
            LOG.error("[getWeather] Exception occurred while getting weather for city : {}", e.getMessage());
            throw new ApplicationException(ErrorCode.ERROR_CODE_1.getMessage());
        }
    }
}
