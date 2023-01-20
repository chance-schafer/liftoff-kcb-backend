package org.launchcode.liftoff_kcb_backend.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.launchcode.liftoff_kcb_backend.model.BusinessDetails;
import org.launchcode.liftoff_kcb_backend.model.BusinessType;
import org.launchcode.liftoff_kcb_backend.model.OwnerType;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusinessDTO {
    private Long id;
    private String name;


    private BusinessDetailsDto businessDetails;

    private BusinessTypeDto businessType;

    private Set<OwnerTypeDto> ownerType;


    private BusinessLocationDto businessLocation;
    private long ownerId;
}
