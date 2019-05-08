package com.example.bellIntegrator.organization.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrganizationViewListIn {

    @NotEmpty (message = "name is required field")
    @Size (max = 50, message = "name max size 50")
    public String name;

    @Size (max = 20, message = "inn max size 20")
    public String inn;

    public Boolean isActive;

}
