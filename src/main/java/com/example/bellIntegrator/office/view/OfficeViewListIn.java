package com.example.bellIntegrator.office.view;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeViewListIn {

    @NotNull
    public Long orgId;

    @Size(max = 50)
    public String name;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;
}
