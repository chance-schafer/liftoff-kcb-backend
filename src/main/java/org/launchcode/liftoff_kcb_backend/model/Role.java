package org.launchcode.liftoff_kcb_backend.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Role extends AbstractEntity{
    private String name;

}
