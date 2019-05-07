package com.example.bellIntegrator.office.view;

import com.example.bellIntegrator.organization.model.Organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OfficeView {

    @NotEmpty
    public String id;

    @NotEmpty
    public Organization org;

    @Size(max = 50)
    public String name;

    @Size(max = 100)
    public String address;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;
}
