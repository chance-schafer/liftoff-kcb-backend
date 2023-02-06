package org.launchcode.liftoff_kcb_backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.exception.ResourceNotFoundException;
import org.launchcode.liftoff_kcb_backend.mapper.BusinessMapper;
import org.launchcode.liftoff_kcb_backend.model.Business;
import org.launchcode.liftoff_kcb_backend.model.User;
import org.launchcode.liftoff_kcb_backend.repository.BusinessRepository;
import org.launchcode.liftoff_kcb_backend.repository.UserRepository;
import org.launchcode.liftoff_kcb_backend.service.BusinessService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BusinessServiceImpl implements BusinessService {
    private final BusinessRepository businessRepository;
    private final UserRepository userRepository;
    private final BusinessMapper businessMapper;


    @Override
    public BusinessDTO createBusiness(BusinessDTO businessDTO, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        Business business = businessMapper.dtoToModel(businessDTO);
        business.setOwner(user);
        business = businessRepository.save(business);
        return businessMapper.modelToDto(business);
    }

    @Override
    public BusinessDTO createBusiness(BusinessDTO businessDTO) {
        return null;
    }

    @Override
    public BusinessDTO getBusinessById(Long id) {
        Business business = businessRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Business", "id", id));

        return businessMapper.modelToDto(business);
    }

    @Override
    public List<BusinessDTO> getBusinessesByIds(List<Long> ids) {
        return ids.stream()
                .map(this::getBusinessById)
                .toList();
    }

    @Override
    public BusinessDTO updateBusiness(Long businessId, BusinessDTO businessDTO) {
        // get existing business by id
        Business existingBusiness = businessRepository.findById(businessId)
                .orElseThrow(() -> new ResourceNotFoundException("Business", "id", businessId));
        Business newBusiness = businessMapper.dtoToModel(businessDTO);
        newBusiness.setId(existingBusiness.getId());
        newBusiness.setLikedBy(existingBusiness.getLikedBy());
        newBusiness.setOwner(existingBusiness.getOwner());
        newBusiness = businessRepository.save(newBusiness);

        return businessMapper.modelToDto(newBusiness);
    }

    @Override
    public List<BusinessDTO> getAllBusinesses() {
        List<Business> businesses = StreamSupport.stream(businessRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        List<BusinessDTO> businessDTOs = (List<BusinessDTO>) businessMapper.modelsToDtos(businesses);

        return businessDTOs;

    }

    @Override
    public List<BusinessDTO> getBusinessesByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        List<Business> businesses = businessRepository.findByOwnerId(user.getId());
        List<BusinessDTO> businessDTOs = (List<BusinessDTO>) businessMapper.modelsToDtos(businesses);
        return businessDTOs;

    }

    @Override
    public List<BusinessDTO> getBusinessesLikedByUserId(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        List<Business> businesses = businessRepository.findByLikedBy_Id(userId);
        List<BusinessDTO> businessDTOs = (List<BusinessDTO>) businessMapper.modelsToDtos(businesses);
        return businessDTOs;
    }

    @Override
    public void deleteBusiness(Long id) {
        Business business = businessRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Business", "id", id));
        User user = business.getOwner();
        // remove business from user owned businesses
        user.getOwnedBusinesses().remove(business);
        userRepository.save(user);

        businessRepository.delete(business);
    }
}
