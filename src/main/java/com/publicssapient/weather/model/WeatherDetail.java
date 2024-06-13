package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "WeatherDetail", description = "Detailed Weather Data")
@Data
public class WeatherDetail {

    @Schema(name = "id", description = "Weather ID")
    private float id;

    @Schema(name = "main", description = "Main Weather Description")
    private String main;

    @Schema(name = "description", description = "Detailed Weather Description")
    private String description;

    @Schema(name = "icon", description = "Weather Icon")
    private String icon;

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "WeatherDetail{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
