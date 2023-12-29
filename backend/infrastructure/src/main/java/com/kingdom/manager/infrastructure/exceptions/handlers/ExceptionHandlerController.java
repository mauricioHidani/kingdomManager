package com.kingdom.manager.infrastructure.exceptions.handlers;

import com.kingdom.manager.domain.exceptions.DatabaseException;
import com.kingdom.manager.domain.exceptions.DatabaseIntegrityException;
import com.kingdom.manager.domain.exceptions.InvalidArgumentException;
import com.kingdom.manager.domain.exceptions.ResourceNotFoundException;
import com.kingdom.manager.domain.exceptions.models.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Clock;
import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<StandardError> invalidArgument(
            InvalidArgumentException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var response = new StandardError(
                Instant.now(Clock.systemUTC()),
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity
                .status(status)
                .body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(
            ResourceNotFoundException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        var response = new StandardError(
                Instant.now(Clock.systemUTC()),
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity
                .status(status)
                .body(response);
    }

    @ExceptionHandler(DatabaseIntegrityException.class)
    public ResponseEntity<StandardError> databaseIntegrity(
            DatabaseIntegrityException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        var response = new StandardError(
                Instant.now(Clock.systemUTC()),
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity
                .status(status)
                .body(response);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(
            DatabaseException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        var response = new StandardError(
                Instant.now(Clock.systemUTC()),
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity
                .status(status)
                .body(response);
    }

}
