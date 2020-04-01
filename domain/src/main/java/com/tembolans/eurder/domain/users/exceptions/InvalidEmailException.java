package com.tembolans.eurder.domain.users.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super("Invalid email: " + message);
    }
}
