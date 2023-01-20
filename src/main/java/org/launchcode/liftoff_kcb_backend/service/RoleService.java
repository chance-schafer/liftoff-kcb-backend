package org.launchcode.liftoff_kcb_backend.service;

import org.launchcode.liftoff_kcb_backend.dto.RoleDto;
import org.launchcode.liftoff_kcb_backend.model.Role;

public interface RoleService {
    RoleDto getRoleByName(String name);
    RoleDto getRoleById(Long id);
    RoleDto createRole(String name);
    void deleteRole(Long id);

}
