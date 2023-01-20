package org.launchcode.liftoff_kcb_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailsDto {
    private Date timestamp;
    private String message;
    private String details;
}
