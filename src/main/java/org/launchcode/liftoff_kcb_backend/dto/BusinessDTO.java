package org.launchcode.liftoff_kcb_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusinessDTO {
    private Long id;
    @NotBlank
    private String name;


    private BusinessDetailsDto businessDetails;
    private BusinessTypeDto businessType;
    private Set<OwnerTypeDto> ownerTypes;
    private BusinessLocationDto businessLocation;
    private UserInfo owner;
    private int likes;
}
