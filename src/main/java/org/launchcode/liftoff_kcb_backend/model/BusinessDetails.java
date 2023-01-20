package org.launchcode.liftoff_kcb_backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BusinessDetails extends AbstractEntity{
    private String description;
    private String websiteUrl;
}
