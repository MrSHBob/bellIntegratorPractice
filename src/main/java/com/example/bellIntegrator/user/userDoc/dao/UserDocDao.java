package com.example.bellIntegrator.user.userDoc.dao;

import com.example.bellIntegrator.user.userDoc.model.UsersDoc;

import java.util.List;

/**
 * Интерфейс DAO для документа юзера.
 */
public interface UserDocDao {

    /**
     * Возвращение всех документов всех юзеров.
     */
    List<UsersDoc> all();

    /**
     * Возвращение по id документа юзера.
     */
    UsersDoc loadById(Long id);

    /**
     * Добавление нового документа юзера.
     */
    void save(UsersDoc usersDoc);
}
