package org.launchcode.liftoff_kcb_backend.models.dto;

import javax.persistence.Entity;

@Entity
public class BusinessType extends AbstractEntity{

    private String type;

    public BusinessType(String type) {
        this.type = type;
    }

    public BusinessType() {}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
