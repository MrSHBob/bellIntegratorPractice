package com.example.bellIntegrator.user.view;

import com.example.bellIntegrator.office.model.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

public class UserViewSave {

    @NotNull(message = "office cannot be null")
    public Long officeId;

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

    public Integer docCode;

    @Size(max = 200)
    public String docName;

    @Size(max = 15)
    public String docNumber;

    public Date docDate;

    public Integer citizenshipCode;

    public Boolean isIdentified;
}
