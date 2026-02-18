package com.example.platzi_play.web.exception;

import com.example.platzi_play.domain.exception.MovieAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(MovieAlreadyExistsException ext) {
        Error error = new Error("Movie already exists", ext.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error>> handleException(MethodArgumentNotValidException ex) {
        List<Error> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> new Error(fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        Error error = new Error("Internal Server Error", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
}
