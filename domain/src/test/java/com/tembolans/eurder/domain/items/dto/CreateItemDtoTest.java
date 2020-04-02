package com.tembolans.eurder.domain.items.dto;

import com.tembolans.eurder.domain.items.dto.item.Currency;
import com.tembolans.eurder.domain.items.dto.item.Price;
import com.tembolans.eurder.domain.items.exceptions.InvalidPriceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateItemDtoTest {
    private CreateItemDto createItemDto;


    @Nested
    public class price{
        @Test
        void givenARightPrice_ShouldReturnPrice() {
            //GIVEN
            createItemDto = new CreateItemDto("Arduino", "15 EURO", 5);

            //WHEN
            Assertions.assertEquals(createItemDto.getPrice(), new Price(15, Currency.EURO));
        }

        @Test
        void givenNoCurrency_ShouldThrowInvalidPriceException() {
            //GIVEN
            createItemDto = new CreateItemDto("Arduino", "15 ", 5);

            //WHEN
            Assertions.assertThrows(InvalidPriceException.class, () -> createItemDto.getPrice());
        }

        @Test
        void givenNoSpace_ShouldThrowInvalidPriceException() {
            //GIVEN
            createItemDto = new CreateItemDto("Arduino", "15EUR", 5);

            //WHEN
            Assertions.assertThrows(InvalidPriceException.class, () -> createItemDto.getPrice());
        }

        @Test
        void givenNoPrice_ShouldThrowInvalidPriceException() {
            //GIVEN
            createItemDto = new CreateItemDto("Arduino", " EUR", 5);

            //WHEN
            Assertions.assertThrows(InvalidPriceException.class, () -> createItemDto.getPrice());
        }


    }

}