package org.launchcode.liftoff_kcb_backend.data;

import org.launchcode.liftoff_kcb_backend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
