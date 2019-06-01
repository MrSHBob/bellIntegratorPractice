package com.example.bellIntegrator.office.view;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * представление офиса для преобразования в json
 */
public class OfficeViewListIn {

    /**
     * идентификатор организации, к которой относится офис
     */
    @NotNull (message = "OrganizationId is required field")
    public Long orgId;

    /**
     * наименование офиса
     */
    @Size (max = 50, message = "name max size 50")
    public String name;

    /**
     * телефон офиса
     */
    @Size (max = 15, message = "phone max size 15")
    public String phone;

    /**
     * что-то
     */
    public Boolean isActive;
}
