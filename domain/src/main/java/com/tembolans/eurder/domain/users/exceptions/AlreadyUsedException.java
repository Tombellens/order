package com.tembolans.eurder.domain.users.exceptions;

public class AlreadyUsedException extends RuntimeException {
    public AlreadyUsedException(String message) {
        super("There is a user registered with the same credentials: " + message);
    }
}
