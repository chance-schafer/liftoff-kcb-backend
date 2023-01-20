package org.launchcode.liftoff_kcb_backend.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.launchcode.liftoff_kcb_backend.model.Business;
import org.launchcode.liftoff_kcb_backend.model.Role;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private Set<Business> ownedBusinesses = new HashSet<>();
}
