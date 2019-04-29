package com.example.bellIntegrator.user.view;

import com.example.bellIntegrator.office.model.Office;
import com.example.bellIntegrator.userDoc.model.UsersDoc;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Instant;

public class UserViewGet {

    public Long id;

    public String firstName;

    public String secondName;

    public String middleName;

    public String position;

    public String phone;

    public String docName;

    public String docNumber;

    public Instant docDate;

    public String citizenshipName;

    public String citizenshipCode;

    public Boolean isIdentified;

    @Override
    public String toString() {
        return"{id:" + id + ";firstName:" + firstName + ";secondName:" + secondName + ";middleName:" + middleName +
                ";position:" + position + ";phone:" + phone + ";docName:" + docName +";docNumber:" + docNumber +
                ";docDate:" + docDate +";citizenshipName:" + citizenshipName +";citizenshipCode:" + citizenshipCode +
                ";isIdentified:" + isIdentified + "}";
    }
}
