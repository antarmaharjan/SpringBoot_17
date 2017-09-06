package me.ratna.springboot17.repositories;

import me.ratna.springboot17.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Long> {
    Role findByRole(String role);

}
