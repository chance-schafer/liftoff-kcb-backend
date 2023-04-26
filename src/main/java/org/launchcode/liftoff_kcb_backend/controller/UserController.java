package org.launchcode.liftoff_kcb_backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.dto.RoleDto;
import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.security.CustomUser;
import org.launchcode.liftoff_kcb_backend.service.BusinessService;
import org.launchcode.liftoff_kcb_backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final BusinessService businessService;

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


    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

//    Create endpoint for getting user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    // create endpoint for getting the roles of a user
    @GetMapping("/{id}/roles")
    public ResponseEntity<RolesDTO> getRolesByUserId(@PathVariable long id) {
        return ResponseEntity.ok(userService.getRolesByUserId(id));
    }

    // create endpiont for getting authenticated user's roles
    @GetMapping("/me/roles")
    public ResponseEntity<RolesDTO> getRolesByAuthenticatedUser(Authentication authentication) {
        CustomUser user = (CustomUser) authentication.getPrincipal();
        Long userId = user.getId();
        return ResponseEntity.ok(userService.getRolesByUserId(userId));
    }

    // create endpoint for getting authenticated user
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getAuthenticatedUser(Authentication authentication) {
        return ResponseEntity.ok(userService.findByUsername(authentication.getName()));
    }

    @GetMapping("/{id}/owned-businesses")
    public ResponseEntity<List<BusinessDTO>> getOwnedBusinessesByUserId(@PathVariable long id) {
        return ResponseEntity.ok(businessService.getBusinessesByUserId(id));
    }

    @GetMapping("/me/owned-businesses")
    public ResponseEntity<List<BusinessDTO>> getOwnedBusinessesByAuthenticatedUser(Authentication authentication) {
        CustomUser user = (CustomUser) authentication.getPrincipal();
        Long userId = user.getId();
        return ResponseEntity.ok(businessService.getBusinessesByUserId(userId));
    }

    @GetMapping("/me/liked-businesses")
    public ResponseEntity<List<BusinessDTO>> getLikedBusinessesByAuthenticatedUser(Authentication authentication) {
        CustomUser user = (CustomUser) authentication.getPrincipal();
        Long userId = user.getId();
        return ResponseEntity.ok(businessService.getBusinessesLikedByUserId(userId));
    }

    @GetMapping("/{id}/liked-businesses")
    public ResponseEntity<List<BusinessDTO>> getLikedBusinessesByUserId(@PathVariable long id) {
        return ResponseEntity.ok(businessService.getBusinessesLikedByUserId(id));
    }


}
