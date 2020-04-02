package com.tembolans.eurder.domain.items.dto.item;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Price {
    private final String totalPrice;
    private final double price;
    private final Currency currency;

    public Price(double price, Currency currency) {
        this.price = price;
        this.currency = currency;
        totalPrice = price + currency.getSymbol();
    }

    public String getTotalPrice() {
        return totalPrice;
    }
}
