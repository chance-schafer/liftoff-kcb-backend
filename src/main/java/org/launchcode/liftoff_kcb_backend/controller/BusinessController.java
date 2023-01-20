package org.launchcode.liftoff_kcb_backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.security.CustomUser;
import org.launchcode.liftoff_kcb_backend.service.BusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/businesses")
@RequiredArgsConstructor
public class BusinessController {
    private final BusinessService businessService;

    @PutMapping
    public ResponseEntity<BusinessDTO> updateBusiness(@RequestBody BusinessDTO business) {
        return ResponseEntity.ok(businessService.updateBusiness(business));
    }


    @Transactional
    @PostMapping
    public ResponseEntity<BusinessDTO> addBusiness(@RequestBody @Valid BusinessDTO businessDTO, @AuthenticationPrincipal CustomUser user) {
        // get user id from authentication
        Long userId = user.getId();

        BusinessDTO business = businessService.createBusiness(businessDTO, userId);
        return ResponseEntity.created(URI.create("/api/businesses/" + business.getId())).body(business);
    }


    // add endpoint to get all businesses
    @GetMapping
    public ResponseEntity<List<BusinessDTO>> getAllBusinesses() {
        return ResponseEntity.status(HttpStatus.CREATED).body(businessService.getAllBusinesses());
    }

    // endpoint to get a business by id
    @GetMapping("/{id}")
    public ResponseEntity<BusinessDTO> getBusinessById(@PathVariable long id) {
        return ResponseEntity.ok(businessService.getBusinessById(id));
    }

    //  endpoint to delete a business by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBusiness(@PathVariable long id) {
        businessService.deleteBusiness(id);
        return ResponseEntity.noContent().build();
    }

}