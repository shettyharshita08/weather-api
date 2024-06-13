package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "City", description = "City Details")
@Data
public class City {

    @Schema(description = "City Id", example = "2172797")
    private float id;

    @Schema(description = "City Name", example = "London")
    private String name;

    @Schema(description = "City Coordinates", implementation = Coord.class)
    private Coord coord;

    @Schema(description = "Country")
    private String country;

    @Schema(description = "Population")
    private float population;

    @Schema(description = "Timezone")
    private float timezone;

    @Schema(description = "Sunrise Time")
    private float sunrise;

    @Schema(description = "Sunset Time")
    private float sunset;

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getPopulation() {
        return population;
    }

    public void setPopulation(float population) {
        this.population = population;
    }

    public float getTimezone() {
        return timezone;
    }

    public void setTimezone(float timezone) {
        this.timezone = timezone;
    }

    public float getSunrise() {
        return sunrise;
    }

    public void setSunrise(float sunrise) {
        this.sunrise = sunrise;
    }

    public float getSunset() {
        return sunset;
    }

    public void setSunset(float sunset) {
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coord=" + coord +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", timezone=" + timezone +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }
}
