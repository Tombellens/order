package com.tembolans.eurder.domain.items.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.tembolans.eurder.domain.items.dto.item.Currency;
import com.tembolans.eurder.domain.items.dto.item.Price;
import com.tembolans.eurder.domain.items.exceptions.InvalidPriceException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@JsonAutoDetect
@RequiredArgsConstructor
public class CreateItemDto {
    private final @NonNull String name;
    private final @NonNull String price;
    private final  int amount;


    public String getName() {
        return name;
    }

    public Price getPrice() throws InvalidPriceException {
        validatePrice(price);
        String[] priceArray = price.split(" ");
        return new Price(Double.parseDouble(priceArray[0]), Currency.valueOf(priceArray[1].toUpperCase()));
    }

    private void validatePrice(String price) throws InvalidPriceException {
        if (!price.contains(" ")) throw new InvalidPriceException("Price and currency should be divided by exactly one space");
        String[] priceArray = price.split(" ");

        if (priceArray.length != 2 || priceArray[0].length() == 0 ||priceArray[1].length() == 0)
            throw new InvalidPriceException(("Price should be in the following format -> '15 EUR'"));
        validatePriceInteger(priceArray[0]);
        validateCurrency(priceArray[1]);
    }

    private void validateCurrency(String currencyString) {
        try{
            Currency.valueOf(currencyString.toUpperCase());
        }catch(IllegalArgumentException exception){
            throw new InvalidPriceException(currencyString +  " is not accepted as a currency");
        }
    }

    private void validatePriceInteger(String price) {
        try{
            double priceDouble = Double.parseDouble(price);
            if (priceDouble < 0.0 ) throw new InvalidPriceException("Price should be bigger than 0");
        }catch (NumberFormatException exception){
            throw new InvalidPriceException("The price should contain no characters");
        }
    }

    public int getAmount() {
        return amount;
    }
}
