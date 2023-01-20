package org.launchcode.liftoff_kcb_backend.service;

import org.launchcode.liftoff_kcb_backend.model.Role;

public interface RoleService {
    Role getRoleByName(String name);
    Role getRoleById(Long id);
    Role createRole(String name);
    void deleteRole(Long id);

}
