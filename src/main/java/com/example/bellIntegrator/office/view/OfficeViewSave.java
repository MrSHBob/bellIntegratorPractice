package com.example.bellIntegrator.office.view;

import com.example.bellIntegrator.organization.model.Organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeViewSave {

    @NotNull (message = "OrganizationId is required field")
    public Long orgId;

    @Size(max = 50, message = "name max size 50")
    public String name;

    @Size(max = 100, message = "address max size 100")
    public String address;

    @Size(max = 15, message = "phone max size 15")
    public String phone;

    public Boolean isActive;
}
