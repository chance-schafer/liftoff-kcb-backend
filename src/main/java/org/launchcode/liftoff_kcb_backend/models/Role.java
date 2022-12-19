package org.launchcode.liftoff_kcb_backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class Role extends AbstractEntity{

    private String name;

}
