package com.tirsa.storewebapp.generics;

import com.tirsa.storewebapp.generics.apiexceptions.ApiBadRequestException;
import com.tirsa.storewebapp.generics.apiexceptions.ApiForbiddenException;
import com.tirsa.storewebapp.generics.apiexceptions.ApiInternalServerErrorException;
import com.tirsa.storewebapp.generics.apiexceptions.ApiUnprocessableEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiBadRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiBadRequestException e){
        return buildGenericExceptionResponse(e,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {ApiUnprocessableEntityException.class})
    public ResponseEntity<Object> handleApiUnprocessableEntityException(ApiUnprocessableEntityException e){
        return buildGenericExceptionResponse(e,HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = {ApiInternalServerErrorException.class})
    public ResponseEntity<Object> handleApiUnprocessableEntityException(ApiInternalServerErrorException e){
        return buildGenericExceptionResponse(e,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {ApiForbiddenException.class})
    public ResponseEntity<Object> handleApiForbiddenException(ApiForbiddenException e){
        return buildGenericExceptionResponse(e,HttpStatus.FORBIDDEN);
    }

    private ResponseEntity<Object> buildGenericExceptionResponse(RuntimeException e, HttpStatus status){
        ApiExceptionRes apiExceptionRes = new ApiExceptionRes(
                e.getMessage(),
                e,
                status,
                ZonedDateTime.now(ZoneId.of("UTC-3"))
        );
        return new ResponseEntity<>(apiExceptionRes,status);
    }

}
