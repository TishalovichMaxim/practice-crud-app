package by.tishalovichm.crudapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFound(
            ResourceNotFoundException resourceNotFoundException,
            WebRequest webRequest) {

        return new ResponseEntity<>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        resourceNotFoundException.getMessage(),
                        webRequest.getDescription(false),
                        "USER_NOT_FOUND"
                ),
                HttpStatus.NOT_FOUND
        );
    }

}
