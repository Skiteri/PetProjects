package ru.restoraunt.model;

import ru.restoraunt.entity.Goods;
import ru.restoraunt.entity.Order;

import java.util.List;

public class OrderModel {

    public OrderModel(Order order, List<Goods> goods) {
        this.order = order;
        this.goods = goods;
    }

    private Order order;
    private List<Goods> goods;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
