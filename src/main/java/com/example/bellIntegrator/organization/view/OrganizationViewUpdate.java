package com.example.bellIntegrator.organization.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrganizationViewUpdate {

    @NotNull
    public Long id;

    @NotEmpty
    @Size(max = 50)
    public String name;

    @NotEmpty
    @Size(max = 200)
    public String fullName;

    @NotEmpty
    @Size(max = 20)
    public String inn;

    @NotEmpty
    @Size(max = 9)
    public String kpp;

    @NotEmpty
    @Size(max = 100)
    public String address;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;

    @Override
    public String toString() {
        return"{id:" + id + ";name:" + name + ";fullName:" + fullName + ";inn:" + inn + ";kpp:" + kpp
                + ";address:" + address + ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
