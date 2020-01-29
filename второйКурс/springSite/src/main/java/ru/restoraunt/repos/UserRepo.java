package ru.restoraunt.repos;

import org.springframework.data.repository.CrudRepository;
import ru.restoraunt.entity.User;

import java.util.List;


public interface UserRepo extends CrudRepository<User, Integer> {
    User findByActive(boolean active);
}
