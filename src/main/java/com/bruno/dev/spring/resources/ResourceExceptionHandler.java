package com.bruno.dev.spring.resources;

import com.bruno.dev.spring.exceptions.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<StandardError> CategoryNotFound(CategoryNotFoundException e, HttpServletRequest request) {
        StandardError err = StandardError.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .timeStamp(System.currentTimeMillis())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
