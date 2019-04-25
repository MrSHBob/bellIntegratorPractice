package com.example.bellIntegrator.office.view;

import com.example.bellIntegrator.organization.model.Organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OfficeViewListIn {

    @NotEmpty
    public Organization org;

    @Size(max = 50)
    public String name;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;

    @Override
    public String toString() {
        return"{orgId:" + org.getId() + ";name:" + name + ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
