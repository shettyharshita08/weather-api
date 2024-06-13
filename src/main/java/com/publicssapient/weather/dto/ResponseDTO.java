package com.publicssapient.weather.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ResponseDTO", description = "Response Data Transfer Object Used for Exceptions")
public class ResponseDTO {

    @Schema(name = "data", description = "Response Data Used for Exceptions")
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "data=" + data +
                '}';
    }
}
