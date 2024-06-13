package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Clouds", description = "Clouds Data")
@Data
public class Clouds {

    @Schema(name = "all", description = "Cloudiness in Percentage")
    private float all;

    public float getAll() {
        return all;
    }

    public void setAll(float all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
