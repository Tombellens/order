package com.tembolans.eurder.domain.items.dto.item;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Item {
    private final UUID id;
    private final String name;
    private final Price price;
    private final int amount;
    private UrgencyIndicator urgencyIndicator;

    public Item(UUID id, String name, Price price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        urgencyIndicator = urgencyCalculation();
    }

    private UrgencyIndicator urgencyCalculation() {
        for (int i = UrgencyIndicator.values().length-1; i >= 0; i--){
            if (amount > UrgencyIndicator.values()[i].getAmount()) return UrgencyIndicator.values()[i];
        }
        return UrgencyIndicator.NEGATIVE_VALUE;
    }
}
