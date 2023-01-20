package org.launchcode.liftoff_kcb_backend.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.launchcode.liftoff_kcb_backend.dto.RoleDto;
import org.launchcode.liftoff_kcb_backend.exception.ResourceNotFoundException;
import org.launchcode.liftoff_kcb_backend.mapper.RoleMapper;
import org.launchcode.liftoff_kcb_backend.model.Role;
import org.launchcode.liftoff_kcb_backend.repository.RoleRepository;
import org.launchcode.liftoff_kcb_backend.service.RoleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Override
    public RoleDto getRoleByName(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "name", name));

        return roleMapper.modelToDto(role);

    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));

        return roleMapper.modelToDto(role);
    }

    @Override
    public RoleDto createRole(String name) {
//        // check if role already exists
//        if (roleRepository.existsByName(name)) {
//            throw new KCBAPIException(HttpStatus.BAD_REQUEST, "Role already exists");
//        }
//
//        Role role= new Role();
//        role.setName(name);
//        role = roleRepository.save(role);
//
//        return role;
        return null;

    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id));
        roleRepository.delete(role);

        // Log the role that was deleted
        log.info("Role deleted: {}", role);

    }
}
