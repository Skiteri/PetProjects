package com.prok.kpoZachet.services;

import com.prok.kpoZachet.entities.Item;
import com.prok.kpoZachet.entities.Order;
import com.prok.kpoZachet.repos.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService implements Services<Order>{
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> getAll() {
        List<Order> list = new LinkedList<>();
        orderRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Order unit) {
        orderRepository.delete(unit);
    }

    @Override
    public Item save(Order unit) {
        orderRepository.save(unit);
        return null;
    }
}
