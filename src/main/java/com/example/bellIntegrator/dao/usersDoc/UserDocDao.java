package com.example.bellIntegrator.dao.usersDoc;

import com.example.bellIntegrator.model.UsersDoc;

import java.util.List;

public interface UserDocDao {

    List<UsersDoc> all();

    UsersDoc loadById(Long id);

    void save(UsersDoc usersDoc);
}
