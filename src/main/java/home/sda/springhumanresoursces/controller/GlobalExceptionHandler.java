package home.sda.springhumanresoursces.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal arguments...bla bla: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
