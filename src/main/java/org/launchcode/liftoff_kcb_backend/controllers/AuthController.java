package org.launchcode.liftoff_kcb_backend.controllers;

import lombok.AllArgsConstructor;
import org.launchcode.liftoff_kcb_backend.data.UserRepository;
import org.launchcode.liftoff_kcb_backend.dto.AuthResponseDTO;
import org.launchcode.liftoff_kcb_backend.dto.LoginDto;
import org.launchcode.liftoff_kcb_backend.dto.RegisterDto;
import org.launchcode.liftoff_kcb_backend.models.Role;
import org.launchcode.liftoff_kcb_backend.models.User;
import org.launchcode.liftoff_kcb_backend.security.JWTGenerator;
import org.launchcode.liftoff_kcb_backend.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;

    @PostMapping("login")
    @CrossOrigin("*")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
       }

    @PostMapping("register")
    @CrossOrigin("*")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if(userRepository.existsByUsername(registerDto.getUsername())){
            return new ResponseEntity<>("User name is taken", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role roles;
        if(registerDto.getRole()){
            roles = roleService.findByName("OWNER").get();
        }
        else {
            roles = roleService.findByName("USER").get();
        }


        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);


        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
