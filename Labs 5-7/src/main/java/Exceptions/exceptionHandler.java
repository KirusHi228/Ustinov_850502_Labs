package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class exceptionHandler
{
    @ExceptionHandler({RuntimeException.class, BadRequestException.class, InternalServiceException.class})
    public final ResponseEntity<ServiceError> handleException(Exception occurredException) throws IOException
    {

        if (occurredException instanceof RuntimeException || occurredException instanceof BadRequestException)
        {
            ServiceError error = new ServiceError(400, HttpStatus.BAD_REQUEST, occurredException.getMessage());
            return new ResponseEntity<>(error, HttpStatus.OK);
        }

        if (occurredException instanceof InternalServiceException)
        {
            ServiceError error = new ServiceError(500, HttpStatus.INTERNAL_SERVER_ERROR, occurredException.getMessage());
            return new ResponseEntity<>(error, HttpStatus.OK);
        }

        ServiceError error = new ServiceError(500, HttpStatus.INTERNAL_SERVER_ERROR, "Непредвиденная ошибка!");
        return new ResponseEntity<>(error, HttpStatus.OK);
    }

}