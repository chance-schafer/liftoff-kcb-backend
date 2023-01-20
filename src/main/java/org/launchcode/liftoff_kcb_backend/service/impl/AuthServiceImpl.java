package org.launchcode.liftoff_kcb_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.repository.RoleRepository;
import org.launchcode.liftoff_kcb_backend.repository.UserRepository;
import org.launchcode.liftoff_kcb_backend.dto.AuthResponseDTO;
import org.launchcode.liftoff_kcb_backend.dto.LoginDto;
import org.launchcode.liftoff_kcb_backend.dto.RegisterDto;
import org.launchcode.liftoff_kcb_backend.exception.KCBAPIException;
import org.launchcode.liftoff_kcb_backend.model.Role;
import org.launchcode.liftoff_kcb_backend.model.User;
import org.launchcode.liftoff_kcb_backend.security.JWTGenerator;
import org.launchcode.liftoff_kcb_backend.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JWTGenerator jwtGenerator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponseDTO login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtGenerator.generateToken(authentication);

        return new AuthResponseDTO(token);


    }

    @Override
    public String register(RegisterDto registerDto) {

        // Check if username is already taken
        if (userRepository.existsByUsername(registerDto.getUsername())) {
            throw new KCBAPIException(HttpStatus.BAD_REQUEST, "Username is already taken");
        }

        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new KCBAPIException(HttpStatus.BAD_REQUEST, "User Role not set."));

        Role adminRole = roleRepository.findByName("OWNER")
                .orElseThrow(() -> new KCBAPIException(HttpStatus.BAD_REQUEST, "Owner Role not set."));

        if (registerDto.isBusinessOwner()) {
            roles.add(adminRole);
        } else {
            roles.add(userRole);
        }

        userRepository.save(user);

        return "User registered successfully";

    }
}
