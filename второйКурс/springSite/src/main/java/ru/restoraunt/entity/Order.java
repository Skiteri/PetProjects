package ru.restoraunt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class  Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "id_order")
    private int id;

    @Column(name = "Order_Date")
    private Date date;

    @Column(name = "Amount")
    private double amount;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_ID",
            foreignKey = @ForeignKey(name = "ORDER_USER"))
    private User user;

    @Column(name = "Confirmed")
    private boolean confirmed;

    public Order() {
        confirmed = false;
    }

    public Order(User user) {
        this();
        this.date = new Date();
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", user=" + user +
                ", confirmed=" + confirmed +
                '}';
    }
}
