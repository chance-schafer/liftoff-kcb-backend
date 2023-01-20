package org.launchcode.liftoff_kcb_backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.RoleDto;
import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    @GetMapping()
//    public ResponseEntity<UserDTO> getUserInfo(Authentication authentication) {
//        //        User user = userService.findByUsername(authentication.getName());
//        //
//        ////        UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getRoles());
//        //        UserDTO userDTO = new UserDTO();
//        //        userDTO.setId(user.getId());
//        //        userDTO.setUsername(user.getUsername());
//        //        userDTO.setRoles(user.getRoles());
//        //        userDTO.setOwnedBusinesses(user.getOwnedBusinesses());
//        //
//        //        return ResponseEntity.ok(userDTO);
//        return null;
//    }

    @GetMapping("/roles")
    public RolesDTO getUserRoles(Authentication authentication) {
        return userService.getRolesByUsername(authentication.getName());
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
