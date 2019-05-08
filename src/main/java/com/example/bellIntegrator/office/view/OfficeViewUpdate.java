package com.example.bellIntegrator.office.view;

import com.example.bellIntegrator.organization.model.Organization;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeViewUpdate {

    @NotNull (message = "Id is required field")
    public Long id;

    @NotEmpty (message = "name is required field")
    @Size (max = 50, message = "name max size 50")
    public String name;

    @NotEmpty (message = "address is required field")
    @Size (max = 100, message = "address max size 50")
    public String address;

    @Size (max = 15, message = "phone max size 50")
    public String phone;

    public Boolean isActive;
}
