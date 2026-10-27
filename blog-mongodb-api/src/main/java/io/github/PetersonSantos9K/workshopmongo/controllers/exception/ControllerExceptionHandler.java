package io.github.PetersonSantos9K.workshopmongo.controllers.exception;

import io.github.PetersonSantos9K.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError exception = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Não encontrado",
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(exception);
    }

}
