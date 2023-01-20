package org.launchcode.liftoff_kcb_backend.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class BusinessLocationDto {
    private long id;
    private String county;

    private String city;
    private String state;
    private String buildingNumber;
    private String streetName;
    private int zipCode;
}
