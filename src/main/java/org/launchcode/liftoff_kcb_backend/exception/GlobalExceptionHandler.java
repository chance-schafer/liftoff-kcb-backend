package org.launchcode.liftoff_kcb_backend.exception;

import org.launchcode.liftoff_kcb_backend.dto.ErrorDetailsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class GlobalExceptionHandler {
    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetailsDto> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }


    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetailsDto> handleAccessDeniedException(
            AccessDeniedException ex, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDetails);
    }

    //global exceptions

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDto> handleGlobalException(
            Exception ex, WebRequest request) {
        ErrorDetailsDto errorDetails = new ErrorDetailsDto(new Date(), ex.getMessage(), request.getDescription(false));

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

}
