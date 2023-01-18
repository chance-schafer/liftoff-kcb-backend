package org.launchcode.liftoff_kcb_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusinessRegistrationDTO {
    private String name;
    private String businessType;
    private String city;
    private String county;
    private String ownerType;
    private int zipCode;
    private String description;
    private String website;
}
