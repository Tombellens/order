package com.tembolans.eurder.domain.items.dto.item;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        return item1.getAmount() - item2.getAmount();
    }
}
