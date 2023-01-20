package org.launchcode.liftoff_kcb_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.repository.UserRepository;
import org.launchcode.liftoff_kcb_backend.model.Role;
import org.launchcode.liftoff_kcb_backend.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements org.launchcode.liftoff_kcb_backend.service.UserService {
    private final UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public Set<Role> getRolesByUsername(String username) {
        User user = findByUsername(username);

        return user.getRoles();
    }

    // remove an owned business from a user
    @Override
    public void removeOwnedBusiness(User user, int businessId) {
        user.getOwnedBusinesses().removeIf(business -> business.getId() == businessId);
        userRepository.save(user);
    }

}
