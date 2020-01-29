package ru.restoraunt.service;

import org.springframework.stereotype.Service;
import ru.restoraunt.entity.Order;
import ru.restoraunt.entity.User;
import ru.restoraunt.repos.OrdersRepo;

import java.util.List;

@Service
public class OrderService {

    private final OrdersRepo ordersRepo;

    public OrderService(OrdersRepo ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public List<Order> findAllOrdersByConfirmed(){
        return ordersRepo.findByConfirmed(true);
    }

    public void saves(Order order){
        ordersRepo.save(order);
    }

    public void deleteOrder(Integer id){
        ordersRepo.deleteById(id);
    }

    public Order findOrderByUser(User user) {
        return ordersRepo.findByUser(user);// найти текущего пользователя
    }

    public Order findOrderById(Integer order_id) {
        return ordersRepo.findById(order_id).get();
    }
}
