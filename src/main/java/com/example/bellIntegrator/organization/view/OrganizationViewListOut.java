package com.example.bellIntegrator.organization.view;

import javax.validation.constraints.Size;

public class OrganizationViewListOut {

    public Long id;

    @Size(max = 50)
    public String name;

    public Boolean isActive;

    @Override
    public String toString() {
        return"{id:" + id + ";name:" + name + ";isActive:" + isActive + "}";
    }
}
