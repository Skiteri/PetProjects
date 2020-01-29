package com.prok.kpoZachet.controllers;

import com.prok.kpoZachet.entities.Order;
import com.prok.kpoZachet.entities.User;
import com.prok.kpoZachet.entities.UserToOrder;
import com.prok.kpoZachet.services.UserToOrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    private final UserToOrdersService userToOrdersService;

    public CardController(UserToOrdersService userToOrdersService) {
        this.userToOrdersService = userToOrdersService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserToOrder> getUserToOrder() {
        return userToOrdersService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserToOrder getUserToOrderById(@PathVariable int id) {
        return userToOrdersService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserToOrder addOrderDetail(@RequestBody Order order, @RequestBody User user) {
        UserToOrder userToOrder = new UserToOrder(order, user);
        userToOrdersService.save(userToOrder);
        return userToOrder;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserToOrder editOrderDetail(@RequestBody UserToOrder userToOrder) {
        userToOrdersService.save(userToOrder);
        return userToOrder;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public UserToOrder deleteOrder(@PathVariable int id) {
        UserToOrder userToOrder = userToOrdersService.findById(id);
        userToOrdersService.delete(userToOrder);
        return userToOrder;
    }
}
