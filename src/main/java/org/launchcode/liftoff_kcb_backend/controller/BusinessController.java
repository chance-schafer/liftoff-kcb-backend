package org.launchcode.liftoff_kcb_backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.liftoff_kcb_backend.dto.BusinessDTO;
import org.launchcode.liftoff_kcb_backend.security.CustomUser;
import org.launchcode.liftoff_kcb_backend.service.BusinessService;
import org.launchcode.liftoff_kcb_backend.service.UserService;
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
    private final UserService userService;

    @PutMapping("/{id}")
    public ResponseEntity<BusinessDTO> updateBusiness(@PathVariable(name = "id") Long id, @RequestBody BusinessDTO business) {
        return ResponseEntity.ok(businessService.updateBusiness(id, business));
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
        return ResponseEntity.status(HttpStatus.OK).body(businessService.getAllBusinesses());
    }

    // get business by owner id
    @GetMapping(params = "ownerId")
    public ResponseEntity<List<BusinessDTO>> getBusinessesByOwnerId(@RequestParam long ownerId) {
        return ResponseEntity.ok(businessService.getBusinessesByUserId(ownerId));
    }

    @GetMapping(params = "ids")
    public ResponseEntity<List<BusinessDTO>> getBusinessesByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(businessService.getBusinessesByIds(ids));
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

    // endpoitn to likea business
    @PostMapping("/{id}/like")
    public ResponseEntity<?> likeBusiness(@PathVariable long id, @AuthenticationPrincipal CustomUser user) {
        userService.likeBusiness(user.getId(), id);
        return ResponseEntity.noContent().build();
    }

    // endpoint to unlike a business
    @DeleteMapping("/{id}/like")
    public ResponseEntity<?> unlikeBusiness(@PathVariable long id, @AuthenticationPrincipal CustomUser user) {
        userService.unlikeBusiness(user.getId(), id);
        return ResponseEntity.noContent().build();
    }

}