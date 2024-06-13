package com.publicssapient.weather.exception;

public enum ErrorCode {
    ERROR_CODE_1("ERROR_CODE_1", "Error occurred while getting weather"),
    ERROR_CODE_2("ERROR_CODE_2", "Error fetching Weather API"),
    ERROR_CODE_3("ERROR_CODE_3", "Error occurred while getting weather forecast details");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
