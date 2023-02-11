package org.launchcode.liftoff_kcb_backend.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class BusinessLocationDto {
    private long id;
    private String county;

    private String city;
    private String state;
    private String streetAddress;
    private int zipCode;
}
