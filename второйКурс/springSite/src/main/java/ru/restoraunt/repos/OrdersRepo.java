package ru.restoraunt.repos;

import org.springframework.data.repository.CrudRepository;
import ru.restoraunt.entity.Order;
import ru.restoraunt.entity.User;

import java.util.List;

public interface OrdersRepo extends CrudRepository<Order, Integer> {
    Order findById(int id);
    Order findByUser(User user);
    List<Order> findByConfirmed(boolean b);
}

