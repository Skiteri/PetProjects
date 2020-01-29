package com.prok.kpoZachet.repos;

import com.prok.kpoZachet.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
