package com.prok.kpoZachet.services;

import com.prok.kpoZachet.entities.Item;
import com.prok.kpoZachet.entities.UserToOrder;
import com.prok.kpoZachet.repos.UserToOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserToOrdersService implements Services<UserToOrder>{

    private final UserToOrderRepository userToOrderRepository;

    public UserToOrdersService(UserToOrderRepository userToOrderRepository) {
        this.userToOrderRepository = userToOrderRepository;
    }

    @Override
    public List<UserToOrder> getAll() {
        Iterator<UserToOrder> all = userToOrderRepository.findAll().iterator();
        List<UserToOrder> list = new LinkedList<>();
        while (all.hasNext()) {
            list.add(all.next());
        }
        return list;
    }
    @Override
    public UserToOrder findById(int id) {
        return userToOrderRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(UserToOrder userToOrder) {
        userToOrderRepository.delete(userToOrder);
    }

    @Override
    public Item save(UserToOrder unit) {
        //TODO
        userToOrderRepository.save(unit);
        return null;
    }


}
