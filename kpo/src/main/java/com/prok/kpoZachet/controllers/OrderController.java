package com.prok.kpoZachet.controllers;

import com.prok.kpoZachet.entities.Order;
import com.prok.kpoZachet.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Order> getOrders() {
        return orderService.getAll();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable int id) {
        return orderService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order addOrder() {
        // TODO посчитать сумму
        Order order = new Order();
        orderService.save(order);
        return order;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Order editOrder(@RequestBody Order order) {
        if (order != null) orderService.save(order);
        return order;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Order deleteOrder(@PathVariable int id) {
        Order byId = orderService.findById(id);
        if (byId != null) orderService.delete(byId);
        return byId;
    }
}
