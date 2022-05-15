package ru.pobedonostsev.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchBookException extends RuntimeException {
    public NoSuchBookException(String message) {
        super(message);
    }
}
