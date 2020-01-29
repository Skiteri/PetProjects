package com.prok.kpoZachet.entities;

import javax.persistence.*;

@Entity
@Table(name = "uto")
public class UserToOrder {
    //many-to-many representation of User has an order
    @Id
    @Column(name = "uto_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false, foreignKey = @ForeignKey(name ="order_id_key"))
    private Order order;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",foreignKey = @ForeignKey(name = "user_id_key"), nullable = false)
    private User user;

    public UserToOrder() {
    }

    public UserToOrder(Order order, User user) {
        this.order = order;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//
//    public void addItemToUsersCart(Item item) {
//        order.addItemToList(item);
//        calculatePrice();
//    }
//
//    public void removeFromUsersCart(Item item) {
//        order.removeItemFromList(item);
//        calculatePrice();
//    }

//    private void calculatePrice() {
//        priceEntireGoodsInCart = order.calculateSum();
//    }
}
