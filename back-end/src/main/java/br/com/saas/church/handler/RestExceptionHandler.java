package br.com.saas.church.handler;

import br.com.saas.church.errors.InvalidIdDetails;
import br.com.saas.church.errors.InvalidIdException;
import br.com.saas.church.errors.ResourceNotFoundDetails;
import br.com.saas.church.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {
        ResourceNotFoundDetails rnfDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidIdException.class)
    public ResponseEntity<?> handlerInvalidIdException(InvalidIdException hiiException) {
        InvalidIdDetails iiDetails = InvalidIdDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.CONFLICT.value())
                .title("ID already existing")
                .detail(hiiException.getMessage())
                .developMessage(hiiException.getClass().getName())
                .build();
        return new ResponseEntity<>(iiDetails, HttpStatus.CONFLICT);
    }
}
