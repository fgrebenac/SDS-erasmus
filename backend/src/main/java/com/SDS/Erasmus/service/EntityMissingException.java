package com.SDS.Erasmus.service;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class EntityMissingException extends RuntimeException {

    private static final long serialVersionUID = 10L;

    public EntityMissingException(Class<?> cls, Object ref) {
        super("Entity with reference " + ref + " of " + cls + " not found.");
    }
}
