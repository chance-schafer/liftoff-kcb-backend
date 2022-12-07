package org.launchcode.liftoff_kcb_backend.models.dto;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Entity
public class BusinessDetails extends AbstractEntity{

    private String description;

    private String websiteUrl;

    public BusinessDetails(String description, String websiteUrl) {
        this.description = description;
        this.websiteUrl = websiteUrl;
    }

    public BusinessDetails() {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }
}
