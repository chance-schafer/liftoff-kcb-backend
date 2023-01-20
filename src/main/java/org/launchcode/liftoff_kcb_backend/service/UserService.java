package org.launchcode.liftoff_kcb_backend.service;

import org.launchcode.liftoff_kcb_backend.model.Role;
import org.launchcode.liftoff_kcb_backend.model.User;

import java.util.Set;

public interface UserService {
    User findByUsername(String username);

    Set<Role> getRolesByUsername(String username);

    // remove an owned business from a user
    void removeOwnedBusiness(User user, int businessId);
}
