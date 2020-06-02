package com.example.Application1;

import org.springframework.http.HttpStatus;

public class ServiceError
{
    private int errorCode;
    private HttpStatus status;
    private String message;

    ServiceError(int errorCode, HttpStatus status, String message)
    {
        this.errorCode = errorCode;
        this.status = status;
        this.message = message;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public HttpStatus getStatus()
    {
        return status;
    }

    public String getMessage()
    {
        return message;
    }
}