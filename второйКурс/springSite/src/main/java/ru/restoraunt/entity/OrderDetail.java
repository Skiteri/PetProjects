package ru.restoraunt.entity;


import javax.persistence.*;

@Entity
@Table(name = "Order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Quanity", nullable = false ) // количество
    private int quanity;

    @Column(name = "Price", nullable = false) // стоимость
    private double price;

    @Column(name = "Amount", nullable = false) // цена
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false,
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD"))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false, //
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD"))
    private Goods goods;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Goods goods) {

        this.order = order;
        this.goods = goods;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", quanity=" + quanity +
                ", price=" + price +
                ", amount=" + amount +
                ", order=" + order.getId() +
                ", goods=" + goods +
                '}';
    }
}
