package com.tembolans.eurder.api.orders;

import com.tembolans.eurder.domain.orders.dto.CreateOrderDto;
import com.tembolans.eurder.domain.orders.dto.OrderDto;
import com.tembolans.eurder.service.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/orders")
public class OrderResource {
    private OrderService orderService;

    @Autowired
    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes="application/json", produces="application/json")
    public OrderDto registerNewOrder(@RequestBody CreateOrderDto createOrderDto ){
        return orderService.registerNewOrder(createOrderDto);
    }



}

