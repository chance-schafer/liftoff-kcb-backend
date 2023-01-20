package org.launchcode.liftoff_kcb_backend.dto;

import lombok.*;
import org.launchcode.liftoff_kcb_backend.model.Role;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
public class RolesDTO {
    private Set<Role> roles = new HashSet<>();
}
