package org.launchcode.liftoff_kcb_backend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.liftoff_kcb_backend.data.RoleRepository;
import org.launchcode.liftoff_kcb_backend.models.Role;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class RoleService {
    private final RoleRepository roleRepository;

    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role createRole(String name) {
        Role role = new Role();
        role.setName(name);

        return saveRole(role);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public Role createRoleIfNotExists(String name) {
        Optional<Role> existingRole = findByName(name);

        if (existingRole.isPresent()) {
            log.info("Role named '{}' already exists, will not create new role.", name);
            return existingRole.get();
        }
        log.info("Role named '{}' does not exist. Creating new role.", name);

        return createRole(name);

    }

}
