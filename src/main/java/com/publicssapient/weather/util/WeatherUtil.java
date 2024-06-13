package com.publicssapient.weather.util;

public class WeatherUtil {
    public static float convertTempToCelsius(float temp) {
        float celsius = temp - 273.15F;
        return Float.parseFloat(String.format("%.2f", celsius));
    }
}
