package br.com.stayease.exceptions;

public class DuplicateObjectException extends RuntimeException{

    public DuplicateObjectException(String message){
        super(message);
    }
}
