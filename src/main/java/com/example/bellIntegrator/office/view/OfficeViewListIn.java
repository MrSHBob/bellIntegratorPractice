package com.example.bellIntegrator.office.view;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeViewListIn {

    @NotNull (message = "OrganizationId is required field")
    public Long orgId;

    @Size (max = 50, message = "name max size 50")
    public String name;

    @Size (max = 15, message = "phone max size 50")
    public String phone;

    public Boolean isActive;
}
