package br.com.stayease.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionsResponse implements Serializable {

    private static final long serialVersinUID = 1L;

    private Date timestamp;
    private String message;
    private String details;

}
