package org.launchcode.liftoff_kcb_backend.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class BusinessType extends AbstractEntity {

    private String name;

    // Review Association
    @OneToMany(mappedBy = "businessType", fetch = FetchType.LAZY)
    private Set<Business> businesses = new HashSet<>();

}
