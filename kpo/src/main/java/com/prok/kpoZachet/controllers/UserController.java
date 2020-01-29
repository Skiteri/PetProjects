package com.prok.kpoZachet.controllers;

import com.prok.kpoZachet.entities.User;
import com.prok.kpoZachet.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public User addUser(@RequestBody String name, @RequestBody Date bd) {
        User user = new User(name, bd);
        userService.save(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User editUser(@RequestBody User user) {
        if (user != null) userService.save(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable int id) {
        User byId = userService.findById(id);
        if (byId != null) userService.delete(byId);
        return byId;
    }
}
