package org.launchcode.liftoff_kcb_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.models.Role;
import org.launchcode.liftoff_kcb_backend.models.User;
import org.launchcode.liftoff_kcb_backend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping()
    public ResponseEntity<UserDTO> getUserInfo(Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());

        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getRoles());

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("roles")
    public RolesDTO getUserRoles(Authentication authentication) {
        return new RolesDTO(new HashSet<>(userService.getRolesByUsername(authentication.getName())));
    }

}
