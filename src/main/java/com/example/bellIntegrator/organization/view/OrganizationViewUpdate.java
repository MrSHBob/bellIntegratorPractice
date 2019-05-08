package com.example.bellIntegrator.organization.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrganizationViewUpdate {

    @NotNull (message = "id is required field")
    public Long id;

    @NotEmpty (message = "name is required field")
    @Size (max = 50, message = "name max size 50")
    public String name;

    @NotEmpty (message = "fullName is required field")
    @Size (max = 200, message = "FullName max size 200")
    public String fullName;

    @NotEmpty (message = "inn is required field")
    @Size (max = 20, message = "inn max size 20")
    public String inn;

    @NotEmpty (message = "kpp is required field")
    @Size (max = 9, message = "kpp max size 9")
    public String kpp;

    @NotEmpty (message = "address is required field")
    @Size (max = 100, message = "address max size 100")
    public String address;

    @Size (max = 15, message = "phone max size 15")
    public String phone;

    public Boolean isActive;
}
