package com.dziuba.resources.exceptions;

import com.dziuba.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError("Not Found", System.currentTimeMillis(), httpStatus.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(error);
    }
}
