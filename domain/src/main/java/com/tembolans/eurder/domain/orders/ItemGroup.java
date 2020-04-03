package com.tembolans.eurder.domain.orders;

import com.tembolans.eurder.domain.items.dto.item.Item;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter@Setter
public class ItemGroup {
    private final Item item;
    private final int amount;
    private final LocalDate shipping;
}
