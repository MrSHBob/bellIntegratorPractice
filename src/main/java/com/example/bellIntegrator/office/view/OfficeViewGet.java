package com.example.bellIntegrator.office.view;

import com.example.bellIntegrator.organization.model.Organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OfficeViewGet {

    public Long id;

    @Size(max = 50)
    public String name;

    @Size(max = 100)
    public String address;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;

    @Override
    public String toString() {
        return"{id:" + id + ";name:" + name + ";address:" + address +
                ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
