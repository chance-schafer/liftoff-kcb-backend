package org.launchcode.liftoff_kcb_backend.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.launchcode.liftoff_kcb_backend.model.Business;
import org.launchcode.liftoff_kcb_backend.model.Role;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String username;
    private Set<RoleDto> roles = new HashSet<>();
    private Set<BusinessInfo> ownedBusinesses = new HashSet<>();
    private Set<BusinessInfo> likedBusinesses = new HashSet<>();
}
