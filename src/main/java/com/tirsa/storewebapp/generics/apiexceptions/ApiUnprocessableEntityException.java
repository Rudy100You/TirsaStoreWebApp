package com.tirsa.storewebapp.generics.apiexceptions;

public class ApiUnprocessableEntityException extends RuntimeException{
    public ApiUnprocessableEntityException(String message)
    {
        super(message);
    }
    public ApiUnprocessableEntityException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
