package org.launchcode.liftoff_kcb_backend.dto;

import lombok.*;

@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
public class BusinessDetailsDto {
    private long id;
    private String description;
    private String websiteUrl;
}
