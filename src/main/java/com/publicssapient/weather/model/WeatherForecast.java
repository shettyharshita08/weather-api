package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "WeatherForecast", description = "Used to display weather forecast")
@Data
public class WeatherForecast {

    @Schema(name = "high", description = "High Temperature in Celsius")
    private float high;

    @Schema(name = "low", description = "Low Temperature in Celsius")
    private float low;

    @Schema(name = "message", description = "Weather Forecast Message for Safe Travel")
    private String message;

    @Schema(name = "date", description = "Date And Time of Weather Forecast")
    private String date;

    @Schema(name = "humidity", description = "Shows the humidity of the day")
    private float humidity;

    @Schema(name = "wind", description = "Wind Details")
    private float wind;

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getWind() {
        return wind;
    }

    public void setWind(float wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "high=" + high +
                ", low=" + low +
                ", message='" + message + '\'' +
                ", date='" + date + '\'' +
                ", humidity=" + humidity +
                ", wind=" + wind +
                '}';
    }
}
