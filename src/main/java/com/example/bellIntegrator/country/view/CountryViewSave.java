package com.example.bellIntegrator.country.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление страны для преобразования в json
 */
public class CountryViewSave {

    /**
     * код страны
     */
    @NotNull (message = "code must not be empty")
    public Integer code;

    /**
     * название страны
     */
    @NotEmpty (message = "name must not be empty")
    @Size (max = 200, message = "name max size is 200")
    public String name;
}
