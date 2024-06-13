package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Coord", description = "Coordinates")
@Data
public class Coord {

    @Schema(description = "Latitude")
    private float lat;

    @Schema(description = "Longitude")
    private float lon;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
