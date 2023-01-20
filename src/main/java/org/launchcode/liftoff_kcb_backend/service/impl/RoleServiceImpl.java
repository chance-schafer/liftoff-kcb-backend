package org.launchcode.liftoff_kcb_backend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.liftoff_kcb_backend.exception.KCBAPIException;
import org.launchcode.liftoff_kcb_backend.exception.ResourceNotFoundException;
import org.launchcode.liftoff_kcb_backend.model.Role;
import org.launchcode.liftoff_kcb_backend.repository.RoleRepository;
import org.launchcode.liftoff_kcb_backend.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public Role getRoleByName(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "name", name));

        return role;
    }

    @Override
    public Role getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));

        return role;
    }

    @Override
    public Role createRole(String name) {
        // check if role already exists
        if (roleRepository.existsByName(name)) {
            throw new KCBAPIException(HttpStatus.BAD_REQUEST, "Role already exists");
        }

        Role role= new Role();
        role.setName(name);
        role = roleRepository.save(role);

        return role;

    }

    @Override
    public void deleteRole(Long id) {
        Role role = getRoleById(id);
        roleRepository.delete(role);
    }
}
