package com.prok.kpoZachet.repos;

import com.prok.kpoZachet.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {    
}
