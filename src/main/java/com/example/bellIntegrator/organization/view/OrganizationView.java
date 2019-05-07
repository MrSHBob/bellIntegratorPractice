package com.example.bellIntegrator.organization.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrganizationView {

    public Long id;

    @Size(max = 50)
    public String name;

    @Size(max = 200)
    public String fullName;

    @Size(max = 20)
    public String inn;

    @Size(max = 9)
    public String kpp;

    @Size(max = 100)
    public String address;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;
}
