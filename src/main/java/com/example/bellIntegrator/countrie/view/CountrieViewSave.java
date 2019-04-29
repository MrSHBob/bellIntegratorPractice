package com.example.bellIntegrator.countrie.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CountrieViewSave {

    @NotNull
    public Integer code;

    @NotEmpty
    public String name;
}
