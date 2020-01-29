package ru.restoraunt.repos;

import org.springframework.data.repository.CrudRepository;
import ru.restoraunt.entity.Order;
import ru.restoraunt.entity.OrderDetail;

import java.util.List;

public interface OrdersDetailRepo extends CrudRepository<OrderDetail, Integer> {
    List<OrderDetail> findByOrder(Order order);
}
