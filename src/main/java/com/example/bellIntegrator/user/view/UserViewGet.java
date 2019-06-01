package com.example.bellIntegrator.user.view;

import java.util.Date;

/**
 * Представление юзера для преобразования в json
 */
public class UserViewGet {

    /**
     * идентификатор
     */
    public Long id;

    /**
     * имя
     */
    public String firstName;

    /**
     * фамилия
     */
    public String secondName;

    /**
     * отчество
     */
    public String middleName;

    /**
     * должность
     */
    public String position;

    /**
     * телефон
     */
    public String phone;

    /**
     * название документа
     */
    public String docName;

    /**
     * номер документа
     */
    public String docNumber;

    /**
     * дата выдачи документа
     */
    public Date docDate;

    /**
     * название страны
     */
    public String citizenshipName;

    /**
     * код страны
     */
    public Integer citizenshipCode;

    /**
     * какое-то поле
     */
    public Boolean isIdentified;
}
