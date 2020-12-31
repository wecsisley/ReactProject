package br.com.saas.church.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InvalidIdException extends RuntimeException {

    public InvalidIdException(String message) {
        super(message);
    }
}
