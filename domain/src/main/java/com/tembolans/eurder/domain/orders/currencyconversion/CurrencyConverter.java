package com.tembolans.eurder.domain.orders.currencyconversion;

import com.tembolans.eurder.domain.items.dto.item.Price;

public interface CurrencyConverter {
     Price convert(Price priceToConvert);
}
