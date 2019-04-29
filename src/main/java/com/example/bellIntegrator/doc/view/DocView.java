package com.example.bellIntegrator.doc.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class DocView {

    public Integer code;

    public String name;

    @Override
    public String toString() {
        return"{name:" + name + ";code:" + code + "}";
    }
}
