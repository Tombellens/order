package com.tembolans.eurder.domain.items.exceptions;

public class SameItemNameException extends RuntimeException {
    public SameItemNameException(String message) {
        super("Another item with the same name is registered: " + message);
    }
}
