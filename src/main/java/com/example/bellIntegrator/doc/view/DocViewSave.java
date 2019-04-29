package com.example.bellIntegrator.doc.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DocViewSave {

    @NotNull
    public Integer code;

    @NotEmpty
    public String name;
}
