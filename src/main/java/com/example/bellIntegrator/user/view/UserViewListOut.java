package com.example.bellIntegrator.user.view;

import com.example.bellIntegrator.office.model.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserViewListOut {

    public String id;

    public String firstName;

    public String secondName;

    public String middleName;

    public String position;

    @Override
    public String toString() {
        return"{id:" + id + ";firstName:" + firstName + ";secondName:" + secondName +
                ";middleName:" + middleName + ";position:" + position + "}";
    }
}
