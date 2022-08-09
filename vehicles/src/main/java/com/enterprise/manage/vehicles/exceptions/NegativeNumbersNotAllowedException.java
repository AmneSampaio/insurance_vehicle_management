package com.enterprise.manage.vehicles.exceptions;

import java.util.Collection;

public class NegativeNumbersNotAllowedException extends  RuntimeException{

    private Collection<String> messages;

    public NegativeNumbersNotAllowedException(String message) {
        super(message);
    }
}
