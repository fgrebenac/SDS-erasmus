package com.SDS.Erasmus.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestDeniedException extends RuntimeException{
    public RequestDeniedException(String message){
        super(message);
    }
}
