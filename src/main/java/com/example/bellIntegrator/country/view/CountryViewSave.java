package com.example.bellIntegrator.country.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CountryViewSave {

    @NotNull
    public Integer code;

    @NotEmpty
    public String name;
}
