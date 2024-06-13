package com.publicssapient.weather.exception;

import com.publicssapient.weather.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ApplicationException.class)
    public ResponseDTO handleApplicationException(ApplicationException applicationException) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(applicationException.getMessage());
        return responseDTO;
    }
}
