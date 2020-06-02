package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception
{
    private int exceptionCode;

    public BadRequestException(int exceptionCode, String message)
    {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public int getExceptionCode()
    {
        return exceptionCode;
    }
}