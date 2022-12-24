package org.launchcode.liftoff_kcb_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.launchcode.liftoff_kcb_backend.models.Role;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolesDTO {
    private Set<Role> roles;
}
