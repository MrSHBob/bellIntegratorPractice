package com.example.bellIntegrator.user.view;

import com.example.bellIntegrator.office.model.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserView {

    @NotEmpty
    public String id;

    @NotEmpty(message = "office cannot be null")
    public Office office;

    @Size(max = 30)
    @NotEmpty(message = "first name cannot be null")
    public String firstName;

    @Size(max = 30)
    public String secondName;

    @Size(max = 30)
    public String middleName;

    @Size(max = 50)
    @NotEmpty(message = "position cannot be null")
    public String position;

    @Size(max = 15)
    public String phone;

    public String citizenshipId;
}
