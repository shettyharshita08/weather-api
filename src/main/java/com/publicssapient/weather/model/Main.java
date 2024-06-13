package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Main", description = "Main Data of Weather")
@Data
public class Main {

    @Schema(description = "Temperature")
    private float temp;

    @Schema(description = "Weather Feels Like")
    private float feels_like;

    @Schema(description = "Minimum Temperature")
    private float temp_min;

    @Schema(description = "Maximum Temperature")
    private float temp_max;

    @Schema(description = "Pressure")
    private float pressure;

    @Schema(description = "Sea Level")
    private float sea_level;

    @Schema(description = "Ground Level")
    private float grnd_level;

    @Schema(description = "Humidity of Weather in Percentage")
    private float humidity;

    @Schema(description = "Temperature in F")
    private float temp_kf;

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(float temp_max) {
        this.temp_max = temp_max;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getSea_level() {
        return sea_level;
    }

    public void setSea_level(float sea_level) {
        this.sea_level = sea_level;
    }

    public float getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(float grnd_level) {
        this.grnd_level = grnd_level;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getTemp_kf() {
        return temp_kf;
    }

    public void setTemp_kf(float temp_kf) {
        this.temp_kf = temp_kf;
    }

    public float getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(float feels_like) {
        this.feels_like = feels_like;
    }

    @Override
    public String toString() {
        return "Main{" +
                "temp=" + temp +
                ", feels_like=" + feels_like +
                ", temp_min=" + temp_min +
                ", temp_max=" + temp_max +
                ", pressure=" + pressure +
                ", sea_level=" + sea_level +
                ", grnd_level=" + grnd_level +
                ", humidity=" + humidity +
                ", temp_kf=" + temp_kf +
                '}';
    }
}
