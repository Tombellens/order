package com.tembolans.eurder.domain.items.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.tembolans.eurder.domain.items.dto.item.Price;
import com.tembolans.eurder.domain.items.dto.item.UrgencyIndicator;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@JsonAutoDetect
@RequiredArgsConstructor
public class ItemDto {
    private final UUID id;
    private final String name;
    private final Price price;
    private final int amount;
    private final UrgencyIndicator urgency;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public UrgencyIndicator getUrgency() {
        return urgency;
    }
}
