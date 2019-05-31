package com.example.bellIntegrator.user.view;

import com.example.bellIntegrator.office.model.Office;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.Date;

public class UserViewUpdate {

    @NotNull (message = "Id is required field")
    public Long id;

    public Long officeId;

    @Size (max = 30, message = "firstName max size 30")
    @NotEmpty (message = "firstName is required field")
    public String firstName;

    @Size (max = 30, message = "secondName max size 30")
    public String secondName;

    @Size (max = 30, message = "middleName max size 30")
    public String middleName;

    @Size (max = 50, message = "position max size 50")
    @NotEmpty (message = "position is required field")
    public String position;

    @Size (max = 15, message = "phone max size 15")
    public String phone;

    @Size (max = 200, message = "docName max size 200")
    public String docName;

    @Size (max = 15, message = "docNumber max size 15")
    public String docNumber;

    public Date docDate;

    public Integer citizenshipCode;

    public Boolean isIdentified;
}
