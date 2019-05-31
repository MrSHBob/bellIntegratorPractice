package com.example.bellIntegrator.doc.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DocViewSave {

    @NotNull (message = "code must not be empty")
    public Integer code;

    @NotEmpty (message = "name must not be empty")
    @Size (max = 200, message = "name max size 200")
    public String name;
}
