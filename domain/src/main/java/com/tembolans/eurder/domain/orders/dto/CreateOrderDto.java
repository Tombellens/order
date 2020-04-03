package com.tembolans.eurder.domain.orders.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.tembolans.eurder.domain.items.ItemRepository;
import com.tembolans.eurder.domain.items.dto.item.Currency;
import com.tembolans.eurder.domain.items.dto.item.Price;
import com.tembolans.eurder.domain.orders.ItemGroup;
import com.tembolans.eurder.domain.orders.currencyconversion.CurrencyConverter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@JsonAutoDetect
public class CreateOrderDto {
    private List<CreateItemGroupDto> createItemGroupDtos;

    public CreateOrderDto() {
        super();
    }

    public CreateOrderDto(List<CreateItemGroupDto> createItemGroupDtos) {
        this.createItemGroupDtos = createItemGroupDtos;
    }

    public List<CreateItemGroupDto> getCreateItemGroupDtos() {
        return createItemGroupDtos;
    }

    public List<ItemGroup> getItemGroups(ItemRepository repo){
        return createItemGroupDtos.stream()
                                .map((createItemGroupDto) -> new ItemGroup(createItemGroupDto.getItemCopy(repo), createItemGroupDto.getAmount(), createItemGroupDto.getShippingDate(repo)))
                                .collect(Collectors.toList());
    }

    public Price getTotalPrice(Currency currency, CurrencyConverter converter, ItemRepository repo){
        double totalPrice = createItemGroupDtos.stream()
                                .mapToDouble((createItemGroupDto) -> converter.convert(createItemGroupDto.getPrice(repo)).getPriceDouble())
                                .sum();
        return new Price(totalPrice, currency);
    }






}
