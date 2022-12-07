package org.launchcode.liftoff_kcb_backend.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Business extends AbstractEntity {

    private String name;

    // Review Association
    @OneToOne(cascade = CascadeType.ALL)
    private BusinessDetails businessDetails;

    // Review Association
    @ManyToOne
    private BusinessType businessType;

    //Check data type for location
    // Review Association
    @OneToOne
    private BusinessLocation businessLocation;

    public Business(String name, BusinessDetails businessDetails, BusinessType businessType, BusinessLocation businessLocation) {
        this.name = name;
        this.businessDetails = businessDetails;
        this.businessType = businessType;
        this.businessLocation = businessLocation;
    }

    public Business () {}

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
