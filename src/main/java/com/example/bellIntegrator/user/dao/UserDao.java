package com.example.bellIntegrator.user.dao;

import com.example.bellIntegrator.user.model.User;
import com.example.bellIntegrator.user.view.UserViewListIn;
import java.util.List;

/**
 * Интерфейс DAO для юзера.
 */
public interface UserDao {

    /**
     * Метод возвращает юзера по id.
     */
    User loadById(Long id);

    /**
     * Метод добавляет новую запись в таблицу "user".
     */
    void save(User user);

    /**
     * Метод изменяет существующего юзера.
     */
    void update(User user);

    /**
     * Фильтр юзеров по id офиса и др. полям.
     */
    List<User> userFilter(UserViewListIn view);
}
