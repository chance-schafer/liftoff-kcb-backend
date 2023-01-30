package org.launchcode.liftoff_kcb_backend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {

    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();


    @OneToMany(mappedBy = "owner")
    @JsonManagedReference
    private Set<Business> ownedBusinesses = new HashSet<>();

    @ManyToMany(mappedBy = "likedBy", cascade = CascadeType.PERSIST)
    private Set<Business> likedBusinesses = new HashSet<>();
}
