package ru.restoraunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.restoraunt.service.GoodsService;
import ru.restoraunt.service.OrderDetailsService;
import ru.restoraunt.service.OrderService;
import ru.restoraunt.entity.Order;
import ru.restoraunt.entity.OrderDetail;
import ru.restoraunt.entity.User;
import ru.restoraunt.repos.UserRepo;

import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    private final UserRepo userRepo;
    private final OrderService orderService;
    private final OrderDetailsService orderDetailsService;

    public OrderController(UserRepo userRepo, OrderService ordersRepo, GoodsService goodsService, OrderDetailsService orderDetailsService) {
        this.userRepo = userRepo;
        this.orderService = ordersRepo;
        this.orderDetailsService = orderDetailsService;
    }

    @RequestMapping(value = "/order/{article_id}", method = RequestMethod.GET)
    public String deteleArticle(@PathVariable("article_id") Integer order_id, Model model) {
        Order orderById = orderService.findOrderById(order_id);
        List<OrderDetail> orders = orderDetailsService.findOrders(orderById);
        model.addAttribute("orderDetails", orders);
        model.addAttribute("wholePrice", orderDetailsService.findOrders(orderById).
                stream()
                .map(OrderDetail::getAmount)
                .reduce(Double::sum).get());
        return "Order";
    }

    @GetMapping("/order")
    public String open_order(Model model){
        List<Order> order = orderService.findAllOrdersByConfirmed();
        model.addAttribute("orders", order);

        return "Orders";
    }

    @RequestMapping(value = "cart/change_quanity", method = RequestMethod.GET)
    public String change_quanity(@RequestParam Integer quantity){
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String showCart(Model model){
        Order order = orderService.findOrderByUser(userRepo.findByActive(true));
        List<OrderDetail> iterator = orderDetailsService.findOrders(order);
        if (iterator.isEmpty()){
            model.addAttribute("state", true);
        } else {
            model.addAttribute("state", false);
            model.addAttribute("order", order.getId());
            model.addAttribute("orderDetails", iterator);
            model.addAttribute("wholePrice", orderDetailsService.findOrders(order).
                                stream()
                                    .map(OrderDetail::getAmount)
                                    .reduce(Double::sum).get());
        }
        return "Cart";
    }

    @PostMapping("/cart")
    public String confirm(@RequestParam String username
                            ,@RequestParam String email
                            ,@RequestParam String telephone
                          ){
        User user = userRepo.findByActive(true);
        user.setName(username);
        user.setEmail(email);
        user.setTelephone(telephone);

        Order order = orderService.findOrderByUser(user);
        order.setConfirmed(true);

        user.setActive(false);

        order.setDate(new Date());

        orderService.saves(order);
        userRepo.save(user);
        return "redirect:/";
    }

}
