import java.util.Date;

public class UserToOrder {
    //many-to-many representation of User has an order
    private int id;
    private Order order;
    private User user;
    private Date ordersCreateDate;
    private int priceEntireGoodsInCart;

    public UserToOrder(int id, Order order, User user) {
        this.id = id;
        this.order = order;
        this.user = user;
        ordersCreateDate = new Date();
    }

    public void addItemToUsersCart(Item item) {
        order.addItemToList(item);
        calculatePrice();
    }

    public void removeFromUsersCart(Item item) {
        order.removeItemFromList(item);
        calculatePrice();
    }

    private void calculatePrice() {
        priceEntireGoodsInCart = order.calculateSum();
    }
}
