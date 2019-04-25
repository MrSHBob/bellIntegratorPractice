package com.example.bellIntegrator.organization.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrganizationViewListIn {

    @NotEmpty
    @Size(max = 50)
    public String name;

    @Size(max = 20)
    public String inn;

    public Boolean isActive;

    @Override
    public String toString() {
        return"{name:" + name + ";inn:" + inn + ";isActive:" + isActive + "}";
    }
}
