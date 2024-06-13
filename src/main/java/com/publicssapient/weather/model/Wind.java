package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Wind", description = "Wind Data")
@Data
public class Wind {

    @Schema(name = "speed", description = "Wind Speed")
    private float speed;

    @Schema(name = "deg", description = "Wind Direction in Degrees")
    private float deg;

    @Schema(name = "gust", description = "Wind Gust")
    private float gust;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(float deg) {
        this.deg = deg;
    }

    public float getGust() {
        return gust;
    }

    public void setGust(float gust) {
        this.gust = gust;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "speed=" + speed +
                ", deg=" + deg +
                ", gust=" + gust +
                '}';
    }
}
