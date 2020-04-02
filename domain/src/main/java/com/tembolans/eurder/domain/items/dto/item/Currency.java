package com.tembolans.eurder.domain.items.dto.item;

public enum Currency {
    EURO("€"), POUND("£"), DOLLAR("$");

    private String symbol;

    Currency(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
