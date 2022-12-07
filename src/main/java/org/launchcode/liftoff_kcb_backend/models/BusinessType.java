package org.launchcode.liftoff_kcb_backend.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BusinessType extends AbstractEntity{

    private String type;

    // Review Association
    @OneToMany(mappedBy = "businessType")
    private final List<Business> events = new ArrayList<>();

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
