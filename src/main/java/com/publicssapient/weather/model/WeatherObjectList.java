package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Schema(name = "WeatherObjectList", description = "Weather Data with multiple details")
@Data
public class WeatherObjectList {

    @Schema(name = "dt", description = "Date and Time of Weather Data in Epoch Format")
    private float dt;

    @Schema(name = "main", description = "Main Weather Details")
    private Main main;

    @Schema(name = "weather", description = "Weather Description Details")
    private List<WeatherDetail> weather = new ArrayList<WeatherDetail>();

    @Schema(name = "clouds", description = "Clouds Details")
    private Clouds clouds;

    @Schema(name = "wind", description = "Wind Details")
    private Wind wind;

    @Schema(name = "visibility", description = "Visibility in Metres")
    private float visibility;

    @Schema(name = "pop", description = "Probability of Precipitation")
    private float pop;

    @Schema(name = "sys", description = "System Details")
    private Sys sys;

    @Schema(name = "dt_txt", description = "Date and Time of Weather Data in Text Format")
    private String dt_txt;

    public float getDt() {
        return dt;
    }

    public void setDt(float dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public List<WeatherDetail> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherDetail> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public float getPop() {
        return pop;
    }

    public void setPop(float pop) {
        this.pop = pop;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "WeatherObjectList{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", visibility=" + visibility +
                ", pop=" + pop +
                ", sys=" + sys +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}
