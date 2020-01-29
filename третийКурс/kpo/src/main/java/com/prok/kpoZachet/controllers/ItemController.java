package com.prok.kpoZachet.controllers;

import com.prok.kpoZachet.entities.Item;
import com.prok.kpoZachet.services.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getItems() {
        return itemService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Item getItemById(@PathVariable int id) {
        return itemService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Item addItem(@RequestBody Item description) {
        return itemService.save(description);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Item editItem(@RequestBody Item item) {
        itemService.save(item);
        return item;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Item deleteItem(@PathVariable int id) {
        Item byId = itemService.findById(id);
        itemService.delete(byId);
        return byId;
    }
}
