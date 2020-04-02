package com.tembolans.eurder.api.items;

import com.tembolans.eurder.domain.items.dto.CreateItemDto;
import com.tembolans.eurder.domain.items.dto.ItemDto;
import com.tembolans.eurder.service.items.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/items")
public class ItemResource {
    private ItemService itemService;

    @Autowired
    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = "application/json", produces ="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreateItemDto itemDto){
        return itemService.addItem(itemDto);
    }

    @GetMapping(path="/overview/{urgency}", produces="application/json")
    @ResponseBody
    public List<ItemDto> getItemOverView(@PathVariable String urgency){
        return itemService.getItemOverview(urgency);
    }
}
