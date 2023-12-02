package br.com.stayease.exceptions;

import br.com.stayease.entities.Exceptions;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateUser(DataIntegrityViolationException exception){
        Exceptions exceptionDup = new Exceptions("Usuário já existe!", "400");
        return ResponseEntity.badRequest().body(exceptionDup);
    }

}
