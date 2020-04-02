package com.tembolans.eurder.domain.items.dto.item;

public enum UrgencyIndicator {
    NEGATIVE_VALUE(-2147483646), STOCK_LOW(0), STOCK_MEDIUM(5), STOCK_HIGH(10);

    private int amount;

    UrgencyIndicator(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
