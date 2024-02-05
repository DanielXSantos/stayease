package br.com.stayease.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Getter
public class DuplicateObjectException extends RuntimeException{

    public DuplicateObjectException(String message){
        super(message);
    }
}
