package com.tirsa.storewebapp.generics.apiexceptions;

public class ApiBadRequestException extends RuntimeException{
    public ApiBadRequestException(String message)
    {
        super(message);
    }
    public ApiBadRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
