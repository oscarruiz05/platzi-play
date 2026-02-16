package com.example.platzi_play.web.exception;

import com.example.platzi_play.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException ext) {
        Error error = new Error("Movie already exists", ext.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
