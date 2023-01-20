package org.launchcode.liftoff_kcb_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String username;
    private String password;
    @JsonProperty("isBusinessOwner")
    private boolean isBusinessOwner;
}
