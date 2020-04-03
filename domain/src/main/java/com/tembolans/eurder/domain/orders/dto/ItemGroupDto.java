package com.tembolans.eurder.domain.orders.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.tembolans.eurder.domain.items.dto.ItemDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@JsonAutoDetect
@Getter @Setter
@RequiredArgsConstructor
public class ItemGroupDto {
    private final ItemDto itemDto;
    private final int amount;
    private final LocalDate shippingDate;

    public int getAmount() {
        return amount;
    }

    public ItemDto getItemDto() {
        return itemDto;
    }
}
