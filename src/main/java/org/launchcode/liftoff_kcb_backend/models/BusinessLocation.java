package org.launchcode.liftoff_kcb_backend.models;

import javax.persistence.Entity;

@Entity
public class BusinessLocation extends AbstractEntity{

    private String county;

    private String city;

    private int zipcode;

    public BusinessLocation(String county, String city, int zipcode) {
        this.county = county;
        this.city = city;
        this.zipcode = zipcode;
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
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }
}
