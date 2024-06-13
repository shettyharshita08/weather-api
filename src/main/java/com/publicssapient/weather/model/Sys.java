package com.publicssapient.weather.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name = "Sys", description = "System Data")
@Data
public class Sys {

    @Schema(description = "Pod")
    private String pod;

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "pod='" + pod + '\'' +
                '}';
    }
}
