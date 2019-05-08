package com.example.bellIntegrator.user.view;

import com.example.bellIntegrator.office.model.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserViewListIn {

    @NotEmpty (message = "officeId is required field")
    public Long officeId;

    @Size (max = 30, message = "firstName max size 30")
    public String firstName;

    @Size (max = 30, message = "secondName max size 30")
    public String secondName;

    @Size (max = 30, message = "middleName max size 30")
    public String middleName;

    @Size (max = 50, message = "position max size 50")
    public String position;

    public Integer docCod;

    public String citizenshipId;
}
