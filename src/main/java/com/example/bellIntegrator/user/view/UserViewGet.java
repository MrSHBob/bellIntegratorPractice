package com.example.bellIntegrator.user.view;

import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.userDoc.model.UsersDoc;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserViewGet {

    public String id;

    public String firstName;

    public String secondName;

    public String middleName;

    public String position;
                                                //вообще все доделать!
    public String phone;

    public UsersDoc userDoc;

    public String citizenshipId;

    @Override
    public String toString() {
        return"{id:" + id + ";firstName:" + firstName +
                ";secondName:" + secondName + ";middleName:" + middleName +
                ";position:" + position + ";phone:" + phone + ";citizenshipId:" + citizenshipId + "}";
    }
}
