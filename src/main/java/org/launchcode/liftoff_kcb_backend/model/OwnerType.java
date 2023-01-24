package org.launchcode.liftoff_kcb_backend.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OwnerType extends AbstractEntity{
    private String name;
}
