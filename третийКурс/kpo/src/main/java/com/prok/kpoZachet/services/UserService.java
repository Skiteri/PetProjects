package com.prok.kpoZachet.services;

import com.prok.kpoZachet.entities.Item;
import com.prok.kpoZachet.entities.User;
import com.prok.kpoZachet.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserService implements Services<User>{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        List<User> list = new LinkedList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(User unit) {
        userRepository.delete(unit);
    }

    @Override
    public Item save(User unit) {
        userRepository.save(unit);
        return null;
    }
}
