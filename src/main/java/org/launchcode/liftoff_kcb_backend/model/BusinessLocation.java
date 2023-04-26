package org.launchcode.liftoff_kcb_backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessLocation extends AbstractEntity{

    private String county;

    private String city;
    private String state;
    private String streetAddress;
    private int zipCode;

    }