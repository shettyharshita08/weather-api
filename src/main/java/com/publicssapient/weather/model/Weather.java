package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Schema(name = "Weather", description = "Detailed Weather Data")
@Data
public class Weather {

    @Schema(name = "cod", description = "Response Code from Weather API")
    private String cod;

    @Schema(name = "message", description = "Response Message from Weather API")
    private float message;

    @Schema(name = "cnt", description = "Count of Weather Data")
    private float cnt;

    @Schema(name = "list", description = "List of Weather Data")
    private List<WeatherObjectList> list = new ArrayList<WeatherObjectList>();

    @Schema(name = "city", description = "City Details")
    private City city;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public float getCnt() {
        return cnt;
    }

    public void setCnt(float cnt) {
        this.cnt = cnt;
    }

    public List<WeatherObjectList> getList() {
        return list;
    }

    public void setList(List<WeatherObjectList> list) {
        this.list = list;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "cod='" + cod + '\'' +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}
