package com.example.bellIntegrator.view;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class UserDocView {

    @NotEmpty
    public String id;

    @NotEmpty
    public String userId;

    public String name;

    @NotEmpty
    public String docCode;

    @NotEmpty
    public String docNumber;

    @NotEmpty
    public Date docDate;                                            //мб потом на строку изменить

    public Boolean isIdentified;

    @Override
    public String toString() {
        return"{id:" + id + ";userId:" + userId + ";name:" + name + ";docCode:" + docCode +
                ";docNumber:" + docNumber + ";docDate:" + docDate + ";isIdentified:" + isIdentified + "}";
    }
}
