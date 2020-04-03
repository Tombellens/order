package com.tembolans.eurder.service.orders;

import com.tembolans.eurder.domain.items.ItemRepository;
import com.tembolans.eurder.domain.items.dto.item.Currency;
import com.tembolans.eurder.domain.items.dto.item.Item;
import com.tembolans.eurder.domain.orders.ItemGroup;
import com.tembolans.eurder.domain.orders.Order;
import com.tembolans.eurder.domain.orders.currencyconversion.ToEuroConverter;
import com.tembolans.eurder.domain.orders.dto.CreateOrderDto;
import com.tembolans.eurder.domain.orders.dto.ItemGroupDto;
import com.tembolans.eurder.domain.orders.dto.OrderDto;
import com.tembolans.eurder.service.items.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    private ItemMapper itemMapper;

    @Autowired
    public OrderMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public Order fromCreateOrderDtoToOrder(CreateOrderDto orderDto, ItemRepository itemRepository){
        return new Order(UUID.randomUUID(),
                orderDto.getItemGroups(itemRepository), orderDto.getTotalPrice(Currency.EURO, new ToEuroConverter(),itemRepository));
    }

    public OrderDto fromOrderToOrderDto(Order registerNewOrder) {
        return new OrderDto(registerNewOrder.getId(), fromItemGroupsToItemGroupDtos(registerNewOrder.getItemGroups()), registerNewOrder.getTotalPrice() );
    }

    public List<ItemGroupDto> fromItemGroupsToItemGroupDtos (List<ItemGroup> items){
        return items.stream()
                        .map((itemGroup) -> new ItemGroupDto(itemMapper.fromItemToItemDto(itemGroup.getItem()), itemGroup.getAmount(), itemGroup.getShipping()))
                        .collect(Collectors.toList());
    }


}
