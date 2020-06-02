package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServiceException extends Exception
{
    private int exceptionCode;
    public InternalServiceException(int currentCode, String message)
    {
        super(message);
        this.exceptionCode = currentCode;
    }

    public int getExceptionCode()
    {
        return exceptionCode;
    }
}