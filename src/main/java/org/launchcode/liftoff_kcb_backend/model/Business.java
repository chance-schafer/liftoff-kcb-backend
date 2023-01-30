package org.launchcode.liftoff_kcb_backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Business extends AbstractEntity {

    private String name;

    // Review Association
    @OneToOne(cascade = CascadeType.ALL)
    private BusinessDetails businessDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    private BusinessType businessType;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<OwnerType> ownerTypes;


    //Check data type for location
    // Review Association
    @OneToOne(cascade = CascadeType.ALL)
    private BusinessLocation businessLocation;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User owner;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<User> likedBy;

}
