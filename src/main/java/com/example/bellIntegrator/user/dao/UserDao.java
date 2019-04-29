package com.example.bellIntegrator.user.dao;

import com.example.bellIntegrator.user.model.User;

import java.util.List;

public interface UserDao {

    User loadById(Long id);

    void save(User user);

    void update(User user);

    List<User> findByOffice(Long officeId);
}
