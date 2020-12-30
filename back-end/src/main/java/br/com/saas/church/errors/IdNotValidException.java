package br.com.saas.church.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class IdNotValidException extends Exception {

    public IdNotValidException(String message) {
        super(message);
    }
}
