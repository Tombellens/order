package com.tembolans.eurder.domain.orders.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.tembolans.eurder.domain.items.ItemRepository;
import com.tembolans.eurder.domain.items.dto.item.Item;
import com.tembolans.eurder.domain.items.dto.item.Price;
import com.tembolans.eurder.domain.orders.exceptions.ItemNotFoundException;
import lombok.RequiredArgsConstructor;


import java.time.LocalDate;

@JsonAutoDetect
@RequiredArgsConstructor
public class CreateItemGroupDto {
    public static final int DAYS_TO_ADD_WHEN_NOT_AVAILABLE = 7;
    private final String itemName;
    private final int amount;


    public String getItemName() {
        return itemName;
    }

    public int getAmount() {
        return amount;
    }

    public Item getItemCopy(ItemRepository itemRepository) throws ItemNotFoundException {
        Item itemToCopy =  itemRepository.getItemByName(itemName)
                .orElseThrow(() -> new ItemNotFoundException("the name " + itemName));
        return new Item(itemToCopy.getId(), itemToCopy.getName(), itemToCopy.getPrice(), itemToCopy.getAmount());
    }

    public LocalDate getShippingDate(ItemRepository itemRepository) throws ItemNotFoundException{
        Item item = itemRepository.getItemByName(itemName)
                    .orElseThrow(() -> new ItemNotFoundException("the name " + itemName));
        if (item.getAmount() - amount >= 0) return LocalDate.now();
        else return LocalDate.now().plusDays(DAYS_TO_ADD_WHEN_NOT_AVAILABLE);
    }

    public Price getPrice(ItemRepository itemRepository) throws ItemNotFoundException{
        Item item = itemRepository.getItemByName(itemName)
                .orElseThrow(() -> new ItemNotFoundException("the name " + itemName));
        double totalPrice = amount * item.getPrice().getPriceDouble();

        return new Price(totalPrice, item.getPrice().getCurrency());
    }
}
