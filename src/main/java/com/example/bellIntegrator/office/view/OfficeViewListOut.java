package com.example.bellIntegrator.office.view;

import com.example.bellIntegrator.organization.model.Organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OfficeViewListOut {

    @NotEmpty
    public String id;

    @Size(max = 50)
    public String name;

    public Boolean isActive;

    @Override
    public String toString() {
        return"{id:" + id + ";name:" + name + ";isActive:" + isActive + "}";
    }
}
