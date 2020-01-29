package ru.restoraunt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.restoraunt.service.GoodsService;
import ru.restoraunt.service.OrderDetailsService;
import ru.restoraunt.service.OrderService;
import ru.restoraunt.entity.Goods;
import ru.restoraunt.entity.Order;
import ru.restoraunt.entity.Role;
import ru.restoraunt.entity.User;
import ru.restoraunt.repos.UserRepo;

import java.util.Collections;

@Controller
public class MainController {

    private final OrderService orderService;
    private final GoodsService goodsService;
    private final OrderDetailsService orderDetailsService;
    private final UserRepo userRepo;

    public MainController(OrderService ordersService, GoodsService goodsService, OrderDetailsService orderDetailsService, UserRepo userRepo) {
        this.orderService = ordersService;
        this.goodsService = goodsService;
        this.orderDetailsService = orderDetailsService;
        this.userRepo = userRepo;
    }

    @GetMapping("/greeting")
    public String hello(){
        User user = new User();
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        orderService.saves(new Order(user));
        return "Greeting";
    }

    @GetMapping
    public String main(Model model){
        Iterable<Goods> goods = goodsService.getAll().findAll();
        model.addAttribute("goods", goods);
        return "Main";
    }

    @GetMapping("/add")
    public String showGoods(){
        return "AddGoods";
    }

    @PostMapping("/add")
    public String add(
            @RequestParam String name,
            @RequestParam double price
    ){
        goodsService.save(new Goods(name, new byte[]{2,3}, price)); // пофиксить картинку
        return "redirect:/";
    }

    @PostMapping("add_cart")
    public String add_to_cart(@RequestParam Integer id){
        Goods byId = goodsService.findById(id);
        User activeUser = userRepo.findByActive(true);
        Order order = orderService.findOrderByUser(activeUser);
        orderDetailsService.add_item(order, byId, 1);
//        orderService.getOrdersRepo().findAll().forEach(System.out::println);
//        orderDetailsService.getAll().findAll().forEach(System.out::println);
//        goodsService.getAll().findAll().forEach(System.out::println);
        return "redirect:/";
    }

}
