package com.prok.kpoZachet.services;

import com.prok.kpoZachet.entities.Item;

import java.util.List;

public interface Services<T> {
    List<T> getAll();
    T findById(int id);
    void delete(T unit);
    Item save(T unit);
}
