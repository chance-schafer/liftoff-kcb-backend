package org.launchcode.liftoff_kcb_backend.service;

import org.launchcode.liftoff_kcb_backend.dto.RoleDto;
import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.model.Role;
import org.launchcode.liftoff_kcb_backend.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    UserDTO findByUsername(String username);

    RolesDTO getRolesByUsername(String username);

    // remove an owned business from a user
    void removeOwnedBusiness(User user, int businessId);

    List<UserDTO> getAllUsers();
}
