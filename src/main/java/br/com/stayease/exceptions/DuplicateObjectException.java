package br.com.stayease.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DuplicateObjectException extends RuntimeException{
    public DuplicateObjectException(String message){
        super(message);
    }
}
