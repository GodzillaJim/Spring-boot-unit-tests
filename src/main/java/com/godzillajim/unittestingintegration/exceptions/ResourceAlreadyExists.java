package com.godzillajim.unittestingintegration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class ResourceAlreadyExists extends RuntimeException {
    public ResourceAlreadyExists(String s) {
        super(s);
    }
}
