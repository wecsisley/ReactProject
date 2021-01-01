package br.com.saas.church.handler;

import br.com.saas.church.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException manvException) {
        List<FieldError> fieldErrorList = manvException.getBindingResult().getFieldErrors();
        String field = fieldErrorList.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldMessages = fieldErrorList.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
        ValidationErrorDetails veDetails = ValidationErrorDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Field Validation Error")
                .detail("Field Validation Error")
                .developerMessage(manvException.getClass().getName())
                .field(field)
                .fildMessage(fieldMessages)
                .build();
        return new ResponseEntity<>(veDetails, HttpStatus.BAD_REQUEST);
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
