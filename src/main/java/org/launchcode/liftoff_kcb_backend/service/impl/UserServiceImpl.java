package org.launchcode.liftoff_kcb_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.RolesDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.exception.ResourceNotFoundException;
import org.launchcode.liftoff_kcb_backend.mapper.RoleMapper;
import org.launchcode.liftoff_kcb_backend.mapper.UserMapper;
import org.launchcode.liftoff_kcb_backend.model.Business;
import org.launchcode.liftoff_kcb_backend.repository.BusinessRepository;
import org.launchcode.liftoff_kcb_backend.repository.UserRepository;
import org.launchcode.liftoff_kcb_backend.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements org.launchcode.liftoff_kcb_backend.service.UserService {
    private final UserRepository userRepository;
    private final BusinessRepository businessRepository;
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

    @Override
    public void likeBusiness(Long userId, Long businessId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        // get business from businessId
        Business business = businessRepository.findById(businessId)
                .orElseThrow(() -> new ResourceNotFoundException("Business", "id", businessId));

        // add business to user's liked businesses
        user.getLikedBusinesses().add(business);
        business.getLikedBy().add(user);

        // save changes
        businessRepository.save(business);
    }

    @Override
    public void unlikeBusiness(Long id, long id1) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        // get business from businessId
        Business business = businessRepository.findById(id1)
                .orElseThrow(() -> new ResourceNotFoundException("Business", "id", id1));

        // add business to user's liked businesses
        user.getLikedBusinesses().remove(business);
        business.getLikedBy().remove(user);

        // save changes
        businessRepository.save(business);

    }

}
