package org.launchcode.liftoff_kcb_backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.model.User;
import org.launchcode.liftoff_kcb_backend.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @GetMapping()
    public ResponseEntity<UserDTO> getUserInfo(Authentication authentication) {
        User user = userService.findByUsername(authentication.getName());

//        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getRoles());
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setRoles(user.getRoles());
        userDTO.setOwnedBusinesses(user.getOwnedBusinesses());

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("roles")
    public RolesDTO getUserRoles(Authentication authentication) {
        return new RolesDTO(new HashSet<>(userService.getRolesByUsername(authentication.getName())));
    }

}
