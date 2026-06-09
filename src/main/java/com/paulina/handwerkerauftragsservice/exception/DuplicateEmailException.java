package com.paulina.handwerkerauftragsservice.exception;

@SuppressWarnings("serial")
public class DuplicateEmailException extends RuntimeException{

    public DuplicateEmailException(final String message) {
        super(message);
    }
}
