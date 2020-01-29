package ru.restoraunt.service;

import org.springframework.stereotype.Service;
import ru.restoraunt.entity.Goods;
import ru.restoraunt.entity.Order;
import ru.restoraunt.entity.OrderDetail;
import ru.restoraunt.repos.OrdersDetailRepo;

import java.util.List;

@Service
public class OrderDetailsService {

    private final OrdersDetailRepo ordersDetailRepo;

    public OrderDetailsService(OrdersDetailRepo ordersDetailRepo) {
        this.ordersDetailRepo = ordersDetailRepo;
    }

    public OrdersDetailRepo getAll(){
        return ordersDetailRepo;
    }

    public void save(OrderDetail goods) {
        ordersDetailRepo.save(goods);
    }

    public OrderDetail findById(Integer id){
        return ordersDetailRepo.findById(id).get();
    }

    public List<OrderDetail> findOrders(Order order){
        /*
        Найти по заказу
         */
        return ordersDetailRepo.findByOrder(order);
    }

    public void add_item(Order order, Goods goods, int quantity){
        OrderDetail orderDetail = new OrderDetail(order,goods);
        orderDetail.setPrice(goods.getPrice());
        orderDetail.setQuanity(quantity);
        orderDetail.setAmount(orderDetail.getPrice() * orderDetail.getQuanity());
        save(orderDetail);
    }

}
