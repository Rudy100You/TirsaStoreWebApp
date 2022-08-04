package com.tirsa.storewebapp.generics.apiexceptions;

public class ApiInternalServerErrorException  extends RuntimeException {
    public ApiInternalServerErrorException(String message) {
        super(message);
    }

    public ApiInternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
