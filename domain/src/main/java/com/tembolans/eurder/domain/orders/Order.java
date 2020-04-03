package com.tembolans.eurder.domain.orders;

import com.tembolans.eurder.domain.items.dto.item.Price;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
@Setter
public class Order {
    private final UUID id;
    private final List<ItemGroup> itemGroups;
    private final Price totalPrice;





}
