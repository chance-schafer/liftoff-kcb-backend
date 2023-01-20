package org.launchcode.liftoff_kcb_backend.repository;

import org.launchcode.liftoff_kcb_backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    Boolean existsByName(String name);

}
