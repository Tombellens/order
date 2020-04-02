package com.tembolans.eurder.domain.items;

import com.tembolans.eurder.domain.items.dto.item.Item;
import com.tembolans.eurder.domain.items.dto.item.ItemComparator;
import com.tembolans.eurder.domain.items.dto.item.UrgencyIndicator;
import com.tembolans.eurder.domain.items.exceptions.SameItemNameException;
import com.tembolans.eurder.domain.users.exceptions.InvalidUrgencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {
    private Map<UUID, Item> itemRepository;

    @Autowired
    public ItemRepository() {
        this.itemRepository = new ConcurrentHashMap<>();
    }

    public Item addItem(Item item) throws SameItemNameException {
        if (!validateName(item))itemRepository.put(item.getId(), item);
        else throw new SameItemNameException(item.getName());
        return item;
    }

    private boolean validateName(Item item) {
        List<String> namesList = itemRepository.values().stream()
                                                .map(itemInStream -> itemInStream.getName())
                                                .collect(Collectors.toList());
        return namesList.contains(item.getName());
    }

    public List<Item> getItemOverview(String urgency) throws InvalidUrgencyException {
        if (urgency == null || urgency.equals("") || urgency.equals("ALL")) return getAllItems();
        UrgencyIndicator indicator = getUrgencyIndicatorFromString(urgency);
        return getItemsByUrgency(indicator);
    }

    private List<Item> getItemsByUrgency(UrgencyIndicator indicator) {
        return itemRepository.values().stream()
                                .filter(item -> item.getUrgencyIndicator() == indicator)
                                .collect(Collectors.toList());
    }

    private List<Item> getAllItems() {
        return itemRepository.values().stream()
                                .sorted(new ItemComparator())
                                .collect(Collectors.toList());
    }

    private UrgencyIndicator getUrgencyIndicatorFromString(String urgency) throws InvalidUrgencyException{
        try{
            return UrgencyIndicator.valueOf(urgency);
        }catch (IllegalArgumentException exception){
            throw new InvalidUrgencyException(urgency + " is not a valid urgency. Provide STOCK_LOW, STOCK_MEDIUM, STOCK_HIGH or nothing");
        }

    }
}
