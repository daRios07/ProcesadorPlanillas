package com.pgd.planillas.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MontoNegativoException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public ErrorDetails montoNegativoException(MontoNegativoException ex, WebRequest request){
        return new ErrorDetails(ex.getMessage(),request.getDescription(false));
    }

    @ExceptionHandler(value = IdEsCeroException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public ErrorDetails idEsCeroException(IdEsCeroException ex, WebRequest request){
        return new ErrorDetails(ex.getMessage(),request.getDescription(false));
    }

    @ExceptionHandler(value = HayNombreVacioException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public ErrorDetails hayNombreVacio(HayNombreVacioException ex, WebRequest request){
        return new ErrorDetails(ex.getMessage(),request.getDescription(false));
    }
}
