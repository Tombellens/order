package com.tembolans.eurder.service.items;

import com.tembolans.eurder.domain.items.ItemRepository;
import com.tembolans.eurder.domain.items.dto.CreateItemDto;
import com.tembolans.eurder.domain.items.dto.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemRepository itemRepository;
    private ItemMapper itemMapper;

    @Autowired
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto addItem(CreateItemDto createItemDto) {
        return itemMapper.fromItemToItemDto(itemRepository.addItem(itemMapper.fromCreateItemDtoToItem(createItemDto)));
    }

    public List<ItemDto> getItemOverview(String urgency) {
        return itemMapper.fromItemToItemDto(itemRepository.getItemOverview(urgency));
    }
}
