package com.example.bellIntegrator.userDoc.view;

import com.example.bellIntegrator.doc.model.Doc;
import com.example.bellIntegrator.user.model.User;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;

public class UserDocView {

    @NotEmpty
    public String id;

    @NotEmpty
    public User user;

    @NotEmpty
    public Doc doc;

    @NotEmpty
    public String docNumber;

    @NotEmpty
    public Instant docDate;                                            //мб потом на строку изменить

    public Boolean isIdentified;

    @Override
    public String toString() {
        return"{id:" + id + ";userId:" + user.getId() + ";docId:" + doc.getId() +
                ";docNumber:" + docNumber + ";docDate:" + docDate + ";isIdentified:" + isIdentified + "}";
    }
}
