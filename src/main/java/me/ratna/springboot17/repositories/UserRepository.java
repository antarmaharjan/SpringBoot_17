package me.ratna.springboot17.repositories;

import me.ratna.springboot17.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User countByEmail(String email);
    User countByUsername(String username);
}
