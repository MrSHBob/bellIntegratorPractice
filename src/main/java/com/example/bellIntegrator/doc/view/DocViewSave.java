package com.example.bellIntegrator.doc.view;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление документа для преобразования в json
 */
public class DocViewSave {

    /**
     * код документа
     */
    @NotNull (message = "code must not be empty")
    public Integer code;

    /**
     * наименование документа
     */
    @NotEmpty (message = "name must not be empty")
    @Size (max = 200, message = "name max size 200")
    public String name;
}
