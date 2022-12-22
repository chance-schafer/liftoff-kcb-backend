package org.launchcode.liftoff_kcb_backend.data;

import org.launchcode.liftoff_kcb_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}
