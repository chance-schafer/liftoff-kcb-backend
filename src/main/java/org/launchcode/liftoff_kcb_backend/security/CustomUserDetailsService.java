package org.launchcode.liftoff_kcb_backend.security;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.model.Role;
import org.launchcode.liftoff_kcb_backend.model.User;
import org.launchcode.liftoff_kcb_backend.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User name not found"));

        // return CustomUSer object
        return new CustomUser(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()), user.getId());

//        return org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUsername())
//                .password(user.getPassword())
//                .authorities(mapRolesToAuthorities(user.getRoles()))
//                .build();
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
