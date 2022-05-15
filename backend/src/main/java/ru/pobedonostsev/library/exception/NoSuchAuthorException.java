package ru.pobedonostsev.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchAuthorException extends RuntimeException {
    public NoSuchAuthorException(String message) {
        super(message);
    }
}
