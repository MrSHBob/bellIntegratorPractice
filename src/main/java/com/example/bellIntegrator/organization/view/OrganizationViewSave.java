package com.example.bellIntegrator.organization.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrganizationViewSave {

    @NotEmpty (message = "name must be filled")
    @Size(max = 50)
    public String name;

    @NotEmpty (message = "fullName must be filled")
    @Size(max = 200)
    public String fullName;

    @NotEmpty (message = "inn must be filled")
    @Size(max = 20)
    public String inn;

    @NotEmpty (message = "kpp must be filled")
    @Size(max = 9)
    public String kpp;

    @NotEmpty (message = "address must be filled")
    @Size(max = 100)
    public String address;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;

    @Override
    public String toString() {
        return"{name:" + name + ";fullName:" + fullName + ";inn:" + inn + ";kpp:" + kpp
                + ";address:" + address + ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
