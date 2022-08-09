package com.enterprise.manage.vehicles.exceptions;

import java.util.Collection;

public class BadRequestException extends RuntimeException{

    private Collection<String> messages;

    public BadRequestException(String message) {
        super(message);
    }
}
