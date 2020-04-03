package com.tembolans.eurder.domain.orders.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.tembolans.eurder.domain.items.dto.item.Price;
import com.tembolans.eurder.domain.orders.ItemGroup;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@JsonAutoDetect
@RequiredArgsConstructor
@Getter
@Setter
public class OrderDto {
    private final UUID id;
    private final List<ItemGroupDto> itemGroupDtos;
    private final Price price;

    public List<ItemGroupDto> getItemGroupDtos() {
        return itemGroupDtos;
    }

    public UUID getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }
}
