package org.launchcode.liftoff_kcb_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.exception.ResourceNotFoundException;
import org.launchcode.liftoff_kcb_backend.mapper.RoleMapper;
import org.launchcode.liftoff_kcb_backend.mapper.UserMapper;
import org.launchcode.liftoff_kcb_backend.repository.UserRepository;
import org.launchcode.liftoff_kcb_backend.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements org.launchcode.liftoff_kcb_backend.service.UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @Override
    public UserDTO findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        return userMapper.modelToDto(user);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));

        return userMapper.modelToDto(user);
    }

    @Override
    public RolesDTO getRolesByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        return roleMapper.toDto(user.getRoles());

    }

    // remove an owned business from a user
    @Override
    public void removeOwnedBusiness(User user, int businessId) {
        user.getOwnedBusinesses().removeIf(business -> business.getId() == businessId);
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = (List<UserDTO>) userMapper.modelsToDtos(users);

        return userDTOs;
    }

}
