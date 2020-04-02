package com.tembolans.eurder.domain.items;

import com.tembolans.eurder.domain.items.dto.item.Currency;
import com.tembolans.eurder.domain.items.dto.item.Item;
import com.tembolans.eurder.domain.items.dto.item.Price;
import com.tembolans.eurder.domain.items.exceptions.SameItemNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class ItemRepositoryTest {
    private ItemRepository itemRepository;
    @BeforeEach
    public void setUp(){
        itemRepository = new ItemRepository();
        Item item = new Item(UUID.randomUUID(), "Raspberry Pi", new Price(40, Currency.EURO), 5);
        itemRepository.addItem(item);
    }
    @Nested
    class AddItem{
        @Test
        void givenSameName_ShouldThrowSameItemNameException() {
            //GIVEN
            Item copyOfItemName = new Item(UUID.randomUUID(), "Raspberry Pi", new Price(50, Currency.EURO), 7);

            //THEN
            Assertions.assertThrows(SameItemNameException.class, () -> itemRepository.addItem(copyOfItemName));
        }

        @Test
        void givenUniqueName_ShouldReturnItem() {
            //GIVEN
            Item uniqueNameItem = new Item(UUID.randomUUID(), "Arduino Uno", new Price(50, Currency.EURO), 7);
        }
    }

}