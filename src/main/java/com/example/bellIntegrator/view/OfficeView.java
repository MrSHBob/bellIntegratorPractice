package com.example.bellIntegrator.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OfficeView {

    @NotEmpty
    public String id;

    @NotEmpty
    public String orgId;

    @Size(max = 50)
    public String name;

    @Size(max = 100)
    public String address;

    @Size(max = 15)
    public String phone;

    public Boolean isActive;

    @Override
    public String toString() {
        return"{id:" + id + ";orgId:" + orgId + ";name:" + name + ";address:" + address +
                ";phone:" + phone + ";isActive:" + isActive + "}";
    }
}
