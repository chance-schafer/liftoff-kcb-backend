package org.launchcode.liftoff_kcb_backend.service;

import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;

import java.util.List;

public interface BusinessService {
    BusinessDTO createBusiness(BusinessDTO businessDTO, Long userId);
    BusinessDTO createBusiness(BusinessDTO businessDTO);
    BusinessDTO getBusinessById(Long id);
    List<BusinessDTO> getBusinessesByIds(List<Long> ids);
    BusinessDTO updateBusiness(Long businessId, BusinessDTO businessDTO);
    List<BusinessDTO> getAllBusinesses();
    List<BusinessDTO> getBusinessesByUserId(Long userId);
    // get businesses liked by user id
    List<BusinessDTO> getBusinessesLikedByUserId(Long userId);

    void deleteBusiness(Long id);
}
