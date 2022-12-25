package org.launchcode.liftoff_kcb_backend.services;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.data.UserRepository;
import org.launchcode.liftoff_kcb_backend.models.Role;
import org.launchcode.liftoff_kcb_backend.models.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<Role> getRolesByUsername(String username) {
        User user = findByUsername(username);

        return user.getRoles();
    }
}
