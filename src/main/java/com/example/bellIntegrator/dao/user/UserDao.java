package com.example.bellIntegrator.dao.user;

import com.example.bellIntegrator.model.Organization;
import com.example.bellIntegrator.model.User;

import java.util.List;

public interface UserDao {

    List<User> all();

    User loadById(Long id);

    void save(User user);
}
