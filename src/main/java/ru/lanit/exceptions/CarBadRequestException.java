package ru.lanit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CarBadRequestException extends RuntimeException {
    public CarBadRequestException(String message) {
        super(message);
    }
}
