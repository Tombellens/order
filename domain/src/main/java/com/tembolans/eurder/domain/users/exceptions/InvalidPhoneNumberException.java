package com.tembolans.eurder.domain.users.exceptions;

public class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException(String message) {
        super("Invalid phone number: " + message);
    }
}
