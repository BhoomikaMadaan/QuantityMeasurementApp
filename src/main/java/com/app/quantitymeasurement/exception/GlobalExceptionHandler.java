package com.app.quantitymeasurement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(
            IllegalArgumentException.class)
    @ResponseStatus(
            HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(
            IllegalArgumentException ex){

        return ex.getMessage();
    }

    @ExceptionHandler(
            ArithmeticException.class)
    @ResponseStatus(
            HttpStatus.BAD_REQUEST)
    public String handleArithmetic(
            ArithmeticException ex){

        return ex.getMessage();
    }

    @ExceptionHandler(
            Exception.class)
    @ResponseStatus(
            HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleGeneral(
            Exception ex){

        return ex.getMessage();
    }
}