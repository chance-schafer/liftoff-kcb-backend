package org.launchcode.liftoff_kcb_backend.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
    private  boolean role;

    public boolean getRole() {
        return this.role;
    }
}
