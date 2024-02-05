package br.com.stayease.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedException extends RuntimeException {

    private static final long serialVersinUID = 1L;
    public UnsupportedException(String ex){
        super(ex);
    }
}
