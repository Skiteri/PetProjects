package com.prok.kpoZachet.services;

import com.prok.kpoZachet.entities.Item;
import com.prok.kpoZachet.repos.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ItemService implements Services<Item> {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAll() {
        List<Item> list = new LinkedList<>();
        itemRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item save(Item unit) {
        //TODO
        return itemRepository.save(unit);
    }

    @Override
    public void delete(Item unit) {
        itemRepository.delete(unit);
    }
}
