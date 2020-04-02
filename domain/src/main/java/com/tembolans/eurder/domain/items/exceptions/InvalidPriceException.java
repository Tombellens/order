package com.tembolans.eurder.domain.items.exceptions;

public class InvalidPriceException extends RuntimeException {
    public InvalidPriceException(String message) {
        super("Invalid price: " + message);
    }
}
