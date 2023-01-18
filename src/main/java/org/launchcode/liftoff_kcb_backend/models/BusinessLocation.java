package org.launchcode.liftoff_kcb_backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class BusinessLocation extends AbstractEntity{

    private String county;

    private String city;

    private int zipCode;

    public BusinessLocation(String county, String city, int zipCode) {
        this.county = county;
        this.city = city;
        this.zipCode = zipCode;
    }

    public BusinessLocation () {}

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipCode;
    }

    public void setZipcode(int zipcode) {
        this.zipCode = zipcode;
    }
}
