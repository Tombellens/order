package com.tembolans.eurder.domain.orders;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class OrderRepository {
    private Map<UUID, Order> orderRepository;

    public OrderRepository() {
        this.orderRepository = new ConcurrentHashMap<>();
    }

    public Order registerNewOrder(Order order) {
        orderRepository.put(order.getId(),order);
        return order;
    }
}
