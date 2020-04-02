package com.tembolans.eurder.domain.items.dto.item;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Double.compare(price1.price, price) == 0 &&
                currency == price1.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, currency);
    }
}
