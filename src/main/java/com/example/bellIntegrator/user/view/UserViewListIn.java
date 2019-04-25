package com.example.bellIntegrator.user.view;

import com.example.bellIntegrator.office.model.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserViewListIn {

    @NotEmpty(message = "office cannot be null")
    public Office office;

    @Size(max = 30)
    public String firstName;

    @Size(max = 30)
    public String secondName;

    @Size(max = 30)
    public String middleName;

    @Size(max = 50)
    public String position;

    public Integer docCod;

    public String citizenshipId;

    @Override
    public String toString() {
        return"{officeId:" + office.getId() + ";firstName:" + firstName +
                ";secondName:" + secondName + ";middleName:" + middleName +
                ";position:" + position + ";docCod:" + docCod + ";citizenshipId:" + citizenshipId + "}";
    }
}
