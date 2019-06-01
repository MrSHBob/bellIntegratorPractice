package com.example.bellIntegrator.user.view;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление юзера для преобразования в json
 */
public class UserViewListIn {

    /**
     * идентификатор офиса, к которому относится юзер
     */
    @NotNull(message = "officeId is required field")
    public Long officeId;

    /**
     * имя
     */
    @Size (max = 30, message = "firstName max size 30")
    public String firstName;

    /**
     * фамилия
     */
    @Size (max = 30, message = "secondName max size 30")
    public String secondName;

    /**
     * отчество
     */
    @Size (max = 30, message = "middleName max size 30")
    public String middleName;

    /**
     * должность
     */
    @Size (max = 50, message = "position max size 50")
    public String position;

    /**
     * код документа
     */
    public Integer docCode;

    /**
     * код страны
     */
    public Integer citizenshipCode;
}
