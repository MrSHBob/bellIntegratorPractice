package com.example.bellIntegrator.user.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Представление юзера для преобразования в json
 */
public class UserViewUpdate {

    /**
     * идентификатор
     */
    @NotNull (message = "Id is required field")
    public Long id;

    /**
     * идентификатор офиса, к которому относится юзер
     */
    public Long officeId;

    /**
     * имя
     */
    @Size (max = 30, message = "firstName max size 30")
    @NotEmpty (message = "firstName is required field")
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
    @NotEmpty (message = "position is required field")
    public String position;

    /**
     * телефон
     */
    @Size (max = 15, message = "phone max size 15")
    public String phone;

    /**
     * название документа
     */
    @Size (max = 200, message = "docName max size 200")
    public String docName;

    /**
     * номер документа
     */
    @Size (max = 15, message = "docNumber max size 15")
    public String docNumber;

    /**
     * дата выдачи документа
     */
    public Date docDate;

    /**
     * код страны
     */
    public Integer citizenshipCode;

    /**
     * какое-то поле
     */
    public Boolean isIdentified;
}
