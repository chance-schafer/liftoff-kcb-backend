package org.launchcode.liftoff_kcb_backend.security;

import org.launchcode.liftoff_kcb_backend.data.UserRepository;
import org.launchcode.liftoff_kcb_backend.models.Role;
import org.launchcode.liftoff_kcb_backend.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User name not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), (Collection<? extends GrantedAuthority>) turnRoleIntoAuthorities(user.getRole()));
    }

    private GrantedAuthority turnRoleIntoAuthorities(Role role){
        return new SimpleGrantedAuthority(role.getName());
    }
}
