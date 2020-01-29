package ru.restoraunt.repos;

import org.springframework.data.repository.CrudRepository;
import ru.restoraunt.entity.Goods;

public interface GoodsRepo extends CrudRepository<Goods, Integer> {
    Goods findByRowid(Integer rowid);
}
