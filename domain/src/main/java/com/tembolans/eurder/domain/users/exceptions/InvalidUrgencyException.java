package com.tembolans.eurder.domain.users.exceptions;

public class InvalidUrgencyException extends RuntimeException {
    public InvalidUrgencyException(String message) {
        super("Invalid urgency provided: " + message);
    }
}
