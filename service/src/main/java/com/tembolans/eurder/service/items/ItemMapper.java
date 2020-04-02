package com.tembolans.eurder.service.items;

import com.tembolans.eurder.domain.items.dto.CreateItemDto;
import com.tembolans.eurder.domain.items.dto.ItemDto;
import com.tembolans.eurder.domain.items.dto.item.Item;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ItemMapper {

    public Item fromCreateItemDtoToItem(CreateItemDto createItemDto){
        return new Item(UUID.randomUUID(), createItemDto.getName(), createItemDto.getPrice(), createItemDto.getAmount());
    }

    public ItemDto fromItemToItemDto(Item item){
        return new ItemDto(item.getId(),item.getName(), item.getPrice(), item.getAmount(), item.getUrgencyIndicator());
    }

    public List<ItemDto> fromItemToItemDto(List<Item> itemList){
        return itemList.stream()
                        .map(item-> new ItemDto(item.getId(), item.getName(), item.getPrice(), item.getAmount(), item.getUrgencyIndicator()))
                        .collect(Collectors.toList());
    }
}
