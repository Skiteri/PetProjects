package com.prok.kpoZachet.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int id;

    @Column(name = "date")
    @Temporal(value=TemporalType.DATE)
    private Date ordersCreateDate;

    @Column(name = "price")
    private int priceEntireGoodsInCart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id",
            foreignKey = @ForeignKey(name = "cart_id"))
    private Item cart;

    public Order() {
        ordersCreateDate = new Date();
    }

    public Order(int priceEntireGoodsInCart) {
        this();
        this.priceEntireGoodsInCart = priceEntireGoodsInCart;
    }

    public Item getCart() {
        return cart;
    }

    public void setCart(Item cart) {
        this.cart = cart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrdersCreateDate() {
        return ordersCreateDate;
    }

    public void setOrdersCreateDate(Date ordersCreateDate) {
        this.ordersCreateDate = ordersCreateDate;
    }

    public int getPriceEntireGoodsInCart() {
        return priceEntireGoodsInCart;
    }

    public void setPriceEntireGoodsInCart(int priceEntireGoodsInCart) {
        this.priceEntireGoodsInCart = priceEntireGoodsInCart;
    }

//    void addItemToList(Item item) {
//        goods.add(item);
//    }
//
//    void removeItemFromList(Item item) {
//        goods.remove(item);
//    }
//
//    public int calculateSum(){
//        int sum = 0;
//        for (Item i:goods) {
//            sum += i.getPrice();
//        }
//        return sum;
//    }
}
