package com.tembolans.eurder.service.orders;

import com.tembolans.eurder.domain.items.ItemRepository;
import com.tembolans.eurder.domain.items.dto.item.Item;
import com.tembolans.eurder.domain.orders.OrderRepository;
import com.tembolans.eurder.domain.orders.dto.CreateOrderDto;
import com.tembolans.eurder.domain.orders.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private ItemRepository itemRepository;
    private OrderMapper orderMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.itemRepository = itemRepository;
    }


    public OrderDto registerNewOrder(CreateOrderDto createOrderDto) {
        return orderMapper.fromOrderToOrderDto(orderRepository.registerNewOrder(orderMapper.fromCreateOrderDtoToOrder(createOrderDto, itemRepository)));
    }
}
