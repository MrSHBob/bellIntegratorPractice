package com.example.bellIntegrator.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CountrieView {

    @NotEmpty
    public String id;

    @NotEmpty
    public String code;

    @Size(max = 200)
    @NotEmpty
    public String name;

    @Override
    public String toString() {
        return"{id:" + id + ";code:" + code + ";name:" + name + "}";
    }
}
