package com.prok.kpoZachet.repos;

import com.prok.kpoZachet.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Integer> {
}
