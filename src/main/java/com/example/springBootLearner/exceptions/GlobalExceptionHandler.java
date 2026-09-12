package com.example.springBootLearner.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalExceptions(IllegalArgumentException ex) {
        Map<String, Object> excMap = new HashMap<>();
        excMap.put("message", ex.getMessage());
        excMap.put("timestamp", LocalDate.now());
        excMap.put("reason", HttpStatus.BAD_REQUEST.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(excMap);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleHttpRequestMethodNotSupportedExceptions(
            HttpRequestMethodNotSupportedException ex) {
        Map<String, Object> excMap = new HashMap<>();
        excMap.put("message", ex.getMessage());
        excMap.put("timestamp", LocalDate.now());
        excMap.put("reason", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(excMap);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> userNotFoundException(
            UserNotFoundException ex) {
        Map<String, Object> excMap = new HashMap<>();
        excMap.put("message", ex.getMessage());
        excMap.put("timestamp", LocalDate.now());
        excMap.put("reason", HttpStatus.NOT_FOUND.getReasonPhrase());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excMap);
    }


}
