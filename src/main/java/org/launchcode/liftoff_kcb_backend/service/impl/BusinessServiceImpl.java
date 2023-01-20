package org.launchcode.liftoff_kcb_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.exception.ResourceNotFoundException;
import org.launchcode.liftoff_kcb_backend.model.*;
import org.launchcode.liftoff_kcb_backend.repository.BusinessRepository;
import org.launchcode.liftoff_kcb_backend.repository.UserRepository;
import org.launchcode.liftoff_kcb_backend.service.BusinessService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    private final BusinessRepository businessRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;


    @Override
    public BusinessDTO createBusiness(BusinessDTO businessDTO, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Business business = modelMapper.map(businessDTO, Business.class);
        business.setOwner(user);
        business = businessRepository.save(business);
        return modelMapper.map(business, BusinessDTO.class);
    }

    @Override
    public BusinessDTO createBusiness(BusinessDTO businessDTO) {
        return null;
    }

    @Override
    public BusinessDTO getBusinessById(Long id) {
        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Business", "id", id));

        return modelMapper.map(business, BusinessDTO.class);
    }

    @Override
    public BusinessDTO updateBusiness(BusinessDTO businessDTO) {
        return null;
    }

    @Override
    public List<BusinessDTO> getAllBusinesses() {
        List<Business> businesses = StreamSupport.stream(businessRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return businesses.stream()
                .map(business -> modelMapper.map(business, BusinessDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BusinessDTO> getBusinessesByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        List<Business> businesses = businessRepository.findByOwnerId(user.getId());

        return businesses.stream()
                .map(business -> modelMapper.map(business, BusinessDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteBusiness(Long id) {
        Business business = businessRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Business", "id", id));
        businessRepository.delete(business);
    }
}
