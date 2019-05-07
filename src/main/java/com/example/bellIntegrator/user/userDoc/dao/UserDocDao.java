package com.example.bellIntegrator.user.userDoc.dao;

import com.example.bellIntegrator.user.userDoc.model.UsersDoc;

import java.util.List;

public interface UserDocDao {

    List<UsersDoc> all();

    UsersDoc loadById(Long id);

    void save(UsersDoc usersDoc);
}
