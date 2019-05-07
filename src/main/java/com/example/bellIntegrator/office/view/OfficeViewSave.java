package com.example.bellIntegrator.office.view;

import com.example.bellIntegrator.organization.model.Organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeViewSave {

    @NotNull
    public Long orgId;

    @Size(max = 50)
    public String name;

    @Size(max = 100)
    public String address;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;
}
