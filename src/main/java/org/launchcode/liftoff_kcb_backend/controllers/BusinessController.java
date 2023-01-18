package org.launchcode.liftoff_kcb_backend.controllers;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.data.BusinessRepository;
import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.dto.BusinessRegistrationDTO;
import org.launchcode.liftoff_kcb_backend.dto.UserDTO;
import org.launchcode.liftoff_kcb_backend.models.*;
import org.launchcode.liftoff_kcb_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/businesses")
@RequiredArgsConstructor
public class BusinessController {

    @Autowired
    private final BusinessRepository businessRepository;
    private final UserService userService;


    @PutMapping
    public ResponseEntity<?> updateBusiness(@RequestBody Business business) {
        // Find the existing business in the database
        Optional<Business> existingBusiness = businessRepository.findById(business.getId());
        if (existingBusiness.isPresent()) {
            // Update the fields of the existing business
            Business updatedBusiness = existingBusiness.get();
            updatedBusiness.setName(business.getName());
            updatedBusiness.setBusinessDetails(business.getBusinessDetails());
            updatedBusiness.setBusinessLocation(business.getBusinessLocation());
            updatedBusiness.setBusinessType(business.getBusinessType());

            // Save the updated business to the database
            businessRepository.save(updatedBusiness);

            // Return a successful response to the client
            return ResponseEntity.ok().build();
        } else {
            // Return a failure response if the business was not found in the database
            return ResponseEntity.notFound().build();
        }
    }


    @Transactional
    @PostMapping
    public ResponseEntity<?> addBusiness(@RequestBody BusinessRegistrationDTO businessRegistrationDTO, @AuthenticationPrincipal org.springframework.security.core.userdetails.User user) {
        // Find the authenticated user
        User authenticatedUser = userService.findByUsername(user.getUsername());

        // Create a new business object
        Business business = new Business();
        business.setName(businessRegistrationDTO.getName());

        BusinessType businessType = new BusinessType(businessRegistrationDTO.getBusinessType());
        business.setBusinessType(businessType);


        OwnerType ownerType = new OwnerType(businessRegistrationDTO.getOwnerType());
        business.setOwnerType(ownerType);

        // add the authenticated user as the owner of the business
        business.setOwner(authenticatedUser);

        // add the business location to the business
        BusinessLocation businessLocation = new BusinessLocation(businessRegistrationDTO.getCounty(), businessRegistrationDTO.getCity(), businessRegistrationDTO.getZipCode());
        business.setBusinessLocation(businessLocation);

        // add the business details to the business
        BusinessDetails businessDetails = new BusinessDetails(businessRegistrationDTO.getDescription(), businessRegistrationDTO.getWebsite());
        business.setBusinessDetails(businessDetails);


        // Save the new business to the database
        businessRepository.save(business);

        // Create a URI for the new business
        String uri = "/api/businesses/" + business.getId();

        // Return business dto as a response
        BusinessDTO businessDTO = convertBusinessToBusinessDTO(business);

        // Return a successful response to the client
        return ResponseEntity.created(URI.create(uri)).body(businessDTO);

    }


    // add endpoint to get all businesses
    @GetMapping
    public ResponseEntity<?> getAllBusinesses() {

        // get all businesses from the database
        Iterable<Business> businesses = businessRepository.findAll();

        List<BusinessDTO> businessDTOs = StreamSupport.stream(businesses.spliterator(), false)
                .map(this::convertBusinessToBusinessDTO)
                .collect(Collectors.toList());

        // return the list of business dtos as a response
        return ResponseEntity.ok(businessDTOs);
    }

    // endpoint to get a business by id
    @GetMapping("/{id}")
    public ResponseEntity<?> getBusinessById(@PathVariable int id) {
        // find the business in the database
        Optional<Business> business = businessRepository.findById(id);

        // if the business is found, convert it to a business dto and return it as a response
        if (business.isPresent()) {
            BusinessDTO businessDTO = convertBusinessToBusinessDTO(business.get());
            return ResponseEntity.ok(businessDTO);
        } else {
            // if the business is not found, return a failure response
            return ResponseEntity.notFound().build();
        }
    }

    //  endpoint to delete a business by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBusiness(@PathVariable int id) {
        // find the business in the database
        Optional<Business> business = businessRepository.findById(id);

        // if the business exists, delete it
        if (business.isPresent()) {
            Business businessToDelete = business.get();
            User owner = businessToDelete.getOwner();
            userService.removeOwnedBusiness(owner, businessToDelete.getId());
            businessRepository.deleteById(id);

            return ResponseEntity.ok().build();
        } else {
            // return a failure response if the business was not found in the database
            return ResponseEntity.notFound().build();
        }
    }


    // utility method to convert a business object to a business DTO
    private BusinessDTO convertBusinessToBusinessDTO(Business business) {
        BusinessDTO businessDTO = new BusinessDTO();
        businessDTO.setId(business.getId());
        businessDTO.setName(business.getName());
        businessDTO.setType(business.getBusinessType());
        businessDTO.setLocation(business.getBusinessLocation());
        UserDTO userDTO = new UserDTO();
        userDTO.setId(business.getOwner().getId());
        userDTO.setUsername(business.getOwner().getUsername());
        businessDTO.setOwner(userDTO);
        return businessDTO;
    }


}