package com.jwelzbacher.swisstournament.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EtAuthException extends RuntimeException {
    public EtAuthException(String message) {
        super(message);
    }
}
