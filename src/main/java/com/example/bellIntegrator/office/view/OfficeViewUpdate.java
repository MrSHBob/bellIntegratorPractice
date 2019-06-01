package com.example.bellIntegrator.office.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * представление офиса для преобразования в json
 */
public class OfficeViewUpdate {

    /**
     * идентификатор
     */
    @NotNull (message = "Id is required field")
    public Long id;

    /**
     * наименование офиса
     */
    @NotEmpty (message = "name is required field")
    @Size (max = 50, message = "name max size 50")
    public String name;

    /**
     * адрес офиса
     */
    @NotEmpty (message = "address is required field")
    @Size (max = 100, message = "address max size 100")
    public String address;

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
