package org.launchcode.liftoff_kcb_backend.controllers;

import org.launchcode.liftoff_kcb_backend.data.BusinessRepository;
import org.launchcode.liftoff_kcb_backend.models.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.Optional;

@RestController
@RequestMapping("/api/businesses")
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;


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


}