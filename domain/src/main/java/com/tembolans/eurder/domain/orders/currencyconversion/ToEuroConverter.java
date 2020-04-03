package com.tembolans.eurder.domain.orders.currencyconversion;

import com.tembolans.eurder.domain.items.dto.item.Currency;
import com.tembolans.eurder.domain.items.dto.item.Price;

public class ToEuroConverter implements CurrencyConverter {
    private final double DOLLAR_TO_EURO = 0.92; // In a later implementation, this data should be fetched from a server
    private final double POUND_TO_EURO = 1.14;

    @Override
    public Price convert(Price priceToConvert) {
        if (priceToConvert.getCurrency().name() == "DOLLAR") return new Price(DOLLAR_TO_EURO * priceToConvert.getPriceDouble(), Currency.EURO );
        if (priceToConvert.getCurrency().name() == "POUND") return new Price(POUND_TO_EURO* priceToConvert.getPriceDouble(), Currency.EURO );
        if (priceToConvert.getCurrency().name() == "EURO") return new Price(1 * priceToConvert.getPriceDouble(), Currency.EURO );
        else throw new IllegalArgumentException("No valid currencies to convert");
    }
}
