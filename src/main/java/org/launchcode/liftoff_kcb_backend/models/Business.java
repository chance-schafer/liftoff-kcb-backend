package org.launchcode.liftoff_kcb_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    // Review Association
    @ManyToOne(cascade = CascadeType.ALL)
    private BusinessType businessType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private OwnerType ownerType;


    //Check data type for location
    // Review Association
    @OneToOne(cascade = CascadeType.ALL)
    private BusinessLocation businessLocation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    private User owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BusinessDetails getBusinessDetails() {
        return businessDetails;
    }

    public void setBusinessDetails(BusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public BusinessLocation getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(BusinessLocation businessLocation) {
        this.businessLocation = businessLocation;
    }

    @Override
    public String toString() {
        return name;
    }
}
