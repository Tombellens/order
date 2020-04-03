package com.tembolans.eurder.domain.orders.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String message) {
        super("Item not found:" + message);
    }
}
