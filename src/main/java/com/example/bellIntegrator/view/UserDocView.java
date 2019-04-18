package com.example.bellIntegrator.view;

import com.example.bellIntegrator.model.User;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;

public class UserDocView {

    @NotEmpty
    public String id;

    @NotEmpty
    public User user;

    public String name;

    @NotEmpty
    public Integer docCode;

    @NotEmpty
    public String docNumber;

    @NotEmpty
    public Instant docDate;                                            //мб потом на строку изменить

    public Boolean isIdentified;

    @Override
    public String toString() {
        return"{id:" + id + ";userId:" + user.getId() + ";name:" + name + ";docCode:" + docCode +
                ";docNumber:" + docNumber + ";docDate:" + docDate + ";isIdentified:" + isIdentified + "}";
    }
}
