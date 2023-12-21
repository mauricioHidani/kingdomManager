package com.kingdom.manager.handlers;

import com.kingdom.manager.exceptions.InvalidRequestException;
import com.kingdom.manager.exceptions.ResourceNotFoundException;
import com.kingdom.manager.responses.StandardErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Clock;
import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> resourceNotFound(
            ResourceNotFoundException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        var response = new StandardErrorResponse(
                Instant.now(Clock.systemUTC()),
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity
                .status(status)
                .body(response);
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<StandardErrorResponse> resourceNotFound(
            InvalidRequestException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        var response = new StandardErrorResponse(
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
