package com.escolasapiapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContentNotFound extends Exception {
    public ContentNotFound(String message) {
        super(message);
    }
}

