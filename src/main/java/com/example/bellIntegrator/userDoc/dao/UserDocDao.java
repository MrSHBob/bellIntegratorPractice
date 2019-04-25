package com.example.bellIntegrator.userDoc.dao;

import com.example.bellIntegrator.userDoc.model.UsersDoc;

import java.util.List;

public interface UserDocDao {

    List<UsersDoc> all();

    UsersDoc loadById(Long id);

    void save(UsersDoc usersDoc);
}
