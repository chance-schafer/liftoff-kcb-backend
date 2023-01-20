package org.launchcode.liftoff_kcb_backend.service;

import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.model.User;

import java.util.List;

public interface UserService {
    UserDTO findByUsername(String username);
    UserDTO findById(Long id);

    RolesDTO getRolesByUserId(Long userId);

    // remove an owned business from a user
    void removeOwnedBusiness(User user, int businessId);

    List<UserDTO> getAllUsers();
}
